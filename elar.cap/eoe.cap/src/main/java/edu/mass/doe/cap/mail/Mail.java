package edu.mass.doe.cap.mail;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;


/**
 * The Class Mail.
 */
@Component
public class Mail {

    private String from;
    private String to;
    private String subject;
    private List<Object> attachments;
    private Map<String, Object> model;

    /**
     * Instantiates a new mail.
     */
    public Mail() {

    }

    /**
     * Gets the from.
     *
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * Sets the from.
     *
     * @param from the new from
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Gets the to.
     *
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets the to.
     *
     * @param to the new to
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Gets the subject.
     *
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the subject.
     *
     * @param subject the new subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Gets the attachments.
     *
     * @return the attachments
     */
    public List<Object> getAttachments() {
        return attachments;
    }

    /**
     * Sets the attachments.
     *
     * @param attachments the new attachments
     */
    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public Map<String, Object> getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param model the model
     */
    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
