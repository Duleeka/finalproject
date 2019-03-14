package com.gn.app.service.AdministrativeTask.GnProfile;

import com.gn.app.dao.administrativeTask.GnProfile.GnProfileDao;
import com.gn.app.dto.administrativeTask.GnProfile.GnProfileDTO;
import com.gn.app.dto.administrativeTask.GnProfile.GnProfileReportDTO;
import com.gn.app.mappers.administrativeTask.GnProfile.GnProfileMapper;
import com.gn.app.model.administrativeTask.GnProfile.GnProfile;
import com.gn.app.security.ReportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


/**
 * Created by hp on 1/7/2019.
 */
@Service
public class GnProfileServiceImpl implements GnProfileService {

    @Autowired
    GnProfileDao gnProfileDao;


    @Override
    public DataTablesOutput<GnProfileDTO> findAllDataTable(DataTablesInput input) {

        DataTablesOutput<GnProfile> output=gnProfileDao.findAll(input);
        DataTablesOutput<GnProfileDTO> dataTablesOutput= null;
        try {
           dataTablesOutput = GnProfileMapper.getInstance().domainToDTODataTablesOutput(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataTablesOutput;
    }

    @Override
    public List<GnProfileDTO> findAll() {
        List<GnProfileDTO> profiles = null;
        try {
            profiles = GnProfileMapper.getInstance().domainToDTOList(gnProfileDao.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profiles;
    }

    @Override
    public GnProfileDTO create(GnProfileDTO gnProfileDTO) {


        if(gnProfileDTO.getId() != null){
            return update(gnProfileDTO);
        }else{
           return save(gnProfileDTO);
        }


    }
    private GnProfileDTO  update(GnProfileDTO gnProfileDTO){
        GnProfile gnProfile=findByIdEntity(gnProfileDTO.getId()).get();
        try {
            GnProfileMapper.getInstance().dtoToDomain(gnProfileDTO,gnProfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveOrUpdate(gnProfile);
        return gnProfileDTO;
    }
    private GnProfileDTO  save(GnProfileDTO gnProfileDTO){
        GnProfile gnProfile=new GnProfile();
        try {
            GnProfileMapper.getInstance().dtoToDomain(gnProfileDTO,gnProfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveOrUpdate(gnProfile);
        return gnProfileDTO;
    }

    private void saveOrUpdate(GnProfile gnProfile){
         gnProfileDao.save(gnProfile);
    }
    @Override
    public GnProfileDTO findById(Integer id) {
        GnProfile gnProfile=findByIdEntity(id).get();
        GnProfileDTO gnProfileDTO=new GnProfileDTO();
        try {
            gnProfileDTO=GnProfileMapper.getInstance().domainToDto(gnProfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gnProfileDTO;
    }


    public Optional<GnProfile> findByIdEntity(Integer id){
        Specification<GnProfile> specification = new Specification<GnProfile>() {
            @Override
            public Predicate toPredicate(Root<GnProfile> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return gnProfileDao.findOne(specification);
    }

    @Override
    public void delete(Integer id) {
        gnProfileDao.delete(findByIdEntity(id).get());
    }

    @Override
    public void print(HttpServletResponse response, HttpServletRequest request, String type) throws Exception {
        InputStream jasperStream = getInputStream(request, "AllGnProfileReportView");
        OutputStream outputStream = null;
        Map<String, Object> params = new HashMap<String, Object>();
        List<GnProfileDTO> gnProfileDTOs = findAll();
        String reportName = "All_gn_profile_data";

        if ("pdf".equals(type)) {
            outputStream = generatePDF(response, jasperStream, params, gnProfileDTOs, reportName);
        } else {
            outputStream = generateCSV(response, jasperStream, params, gnProfileDTOs, reportName);
        }

        outputStream.flush();
        outputStream.close();
    }


    private OutputStream generatePDF( HttpServletResponse response, InputStream jasperStream, Map<String, Object> params, List<GnProfileDTO> gnProfileDTOs, String reportName) throws IOException {
        OutputStream outputStream = getOutPutStram(response, reportName, "application/pdf", ".pdf");
        ReportUtil.getInstance().generatePDF(new GnProfileReportDTO(gnProfileDTOs), jasperStream, params, outputStream);
        return outputStream;
    }

    private OutputStream generateCSV( HttpServletResponse response, InputStream jasperStream, Map<String, Object> params, List<GnProfileDTO> gnProfileDTOs, String reportName) throws IOException {
        OutputStream outputStream = getOutPutStram(response, reportName, "text/csv", ".csv");
        ReportUtil.getInstance().generateCSV(new GnProfileReportDTO(gnProfileDTOs), jasperStream, params, outputStream);
        return outputStream;
    }

    private InputStream getInputStream(HttpServletRequest request, String jasperFileName) throws FileNotFoundException {
        String filePath = request.getServletContext().getRealPath("").concat("/resources/statics/reports/administrativeTask/gnProfile/" + jasperFileName + ".jrxml");
        InputStream jasperStream = new FileInputStream(filePath);
        return jasperStream;
    }

    private OutputStream getOutPutStram(HttpServletResponse response, String fileName, String contentType, String extension) throws IOException {
        response.setContentType(contentType);
        response.setHeader("Content-disposition", "attachment; filename=".concat(fileName).concat(extension));
        OutputStream outputStream = response.getOutputStream();
        return outputStream;
    }

}
