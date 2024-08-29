package com.sab.complaint.service;

import com.sab.complaint.model.ComplaintSubject;
import com.sab.complaint.model.Recipient;
import com.sab.complaint.repository.RecipientRepository;
import com.sab.complaint.request.RecipientRequest;
import com.sab.sabglobal.model.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipientService {

    @Autowired
    RecipientRepository recipientRepository;
    public Recipient getRecipientById(String id) {
        return recipientRepository.findById(id).orElse(null);
    }

    public CommonResponse addRecipient(RecipientRequest recipientRequest) {
        recipientRepository.save(new Recipient().convertToEntity(recipientRequest));
        return new CommonResponse("0000000", "Recipient Saved");
    }
}
