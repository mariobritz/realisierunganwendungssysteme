package mic311.adressbuch;

import java.util.List;

import mic311.adressbuch.AdressbuchController;


import com.googlecode.sslplugin.annotation.Secured;
import com.opensymphony.xwork2.ActionSupport;

@Secured
public class AdressbuchAction extends ActionSupport {
	 
    private static final long serialVersionUID = 9149826260758390091L;
    private Kontakt contact;
    private List<Kontakt> contactList;
    private Long id;
 
    private AdressbuchController adressbuchController;
 
    public AdressbuchAction() {
        adressbuchController = new AdressbuchController();
    }
 
    public String execute() {
        this.contactList = adressbuchController.list();
        System.out.println("execute called");
        return SUCCESS;
    }
 
    public String add() {
        System.out.println(getContact());
        try {
            adressbuchController.add(getContact());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }
 
    public String delete() {
        adressbuchController.delete(getId());
        return SUCCESS;
    }
 
    public Kontakt getContact() {
        return contact;
    }
 
    public List<Kontakt> getContactList() {
        return contactList;
    }
 
    public void setContact(Kontakt contact) {
        this.contact = contact;
    }
 
    public void setContactList(List<Kontakt> contactsList) {
        this.contactList = contactsList;
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
}