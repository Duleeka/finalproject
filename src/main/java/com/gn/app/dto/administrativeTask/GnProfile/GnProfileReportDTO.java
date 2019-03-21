package com.gn.app.dto.administrativeTask.GnProfile;

import com.gn.app.dto.BaseReportDTO;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import java.util.List;

/**
 * Created by hp on 3/12/2019.
 */
public class GnProfileReportDTO implements JRDataSource {
    private int index = -1;
    private List<GnProfileDTO> gnProfileDTOs;

    public GnProfileReportDTO(List<GnProfileDTO> gnProfileDTOs) {
        this.gnProfileDTOs = gnProfileDTOs;
    }

    @Override
    public boolean next() throws JRException {
        index++;
        return index < gnProfileDTOs.size();
    }

    @Override
    public Object getFieldValue(JRField field) throws JRException {

        Object value = null;
        String fieldName = field.getName();

        if ("id".equals(fieldName)) {
            value = gnProfileDTOs.get(index).getId();
        }
        else if ("gnId".equals(fieldName)) {
            value = gnProfileDTOs.get(index).getGnId();
        }
        else if ("firstName".equals(fieldName)) {
            value = gnProfileDTOs.get(index).getFirstName();
        }
        else if ("middleName".equals(fieldName)) {
            value = gnProfileDTOs.get(index).getMiddleName();
        }
        else if ("lastName".equals(fieldName)) {
            value = gnProfileDTOs.get(index).getLastName();
        }
        else if ("officeAddress".equals(fieldName)) {
            value = gnProfileDTOs.get(index).getOfficeAddress();
        }
        else if ("phoneNumber".equals(fieldName)) {
            value = gnProfileDTOs.get(index).getPhoneNumber();
        }
        else if ("appointmentDate".equals(fieldName)) {
            value = gnProfileDTOs.get(index).getAppointmentDate();
        }
        else if ("dateOfDutyAssumed".equals(fieldName)) {
            value = gnProfileDTOs.get(index).getDateOfDutyAssumed();
        }

        return value;
    }
}
