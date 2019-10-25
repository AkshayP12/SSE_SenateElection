package com.onlinevotingsystem.ovs.captcha;

import com.onlinevotingsystem.ovs.validation.ReCaptchaInvalidException;

public interface ICaptchaService {
    void processResponse(final String response) throws ReCaptchaInvalidException;

    String getReCaptchaSite();

    String getReCaptchaSecret();
}
