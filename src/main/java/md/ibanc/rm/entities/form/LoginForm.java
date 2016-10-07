/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.entities.form;

import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Zaițev.Victor
 */
public class LoginForm {

    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9]+([_A-Za-z0-9-])+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    private String mEmail;

    @NotNull
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*#?&\\.-_,|~`])[A-Za-z\\d$@$!%*#?&\\.-_,|~`]{6,20}$")
    private String mPassword;

    @NotNull
    private Map<String, String> devicesDetail;

    public LoginForm() {
    }

    public LoginForm(String mEmail, String mPassword) {
        this.mEmail = mEmail;
        this.mPassword = mPassword;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public Map<String, String> getDevicesDetail() {
        return devicesDetail;
    }

    public void setDevicesDetail(Map<String, String> devicesDetail) {
        this.devicesDetail = devicesDetail;
    }

}
