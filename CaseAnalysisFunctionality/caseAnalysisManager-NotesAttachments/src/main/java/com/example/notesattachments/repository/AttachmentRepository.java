package com.example.notesattachments.repository;

import java.util.List;

import com.example.notesattachments.bean.AttachmentBean;
import com.example.notesattachments.bean.AttachmentReferenceBean;

public interface AttachmentRepository {
	
	AttachmentBean saveAttachment(AttachmentBean attachment);
	AttachmentReferenceBean addAttachment(AttachmentReferenceBean attachment);
	List<AttachmentReferenceBean> retriveAttachmentInternalId(String alertId);

}
