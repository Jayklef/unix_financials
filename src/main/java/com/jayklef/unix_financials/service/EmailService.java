package com.jayklef.unix_financials.service;

import com.jayklef.unix_financials.dto.EmailDetails;

public interface EmailService {

    void sendEmail(EmailDetails emailDetails);
}
