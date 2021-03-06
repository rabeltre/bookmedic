package model;
// Generated Mar 30, 2016 9:11:24 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Reservation generated by hbm2java
 */
public class Reservation  implements java.io.Serializable {


     private Integer id;
     private Medic medic;
     private Pacient pacient;
     private Payment payment;
     private Status status;
     private User user;
     private String title;
     private String note;
     private String message;
     private Date dateAt;
     private Date timeAt;
     private Date createdAt;
     private String symtoms;
     private String sick;
     private String medicaments;
     private Double price;
     private boolean isWeb;

    public Reservation() {
    }

    public Reservation(Integer id) {
        this.id = id;
    }

    public void ponerValores(Medic medic, Pacient pacient, Payment payment, Status status) {
        this.medic = medic;
        this.pacient = pacient;
        this.payment = payment;
        this.status = status;
    }

    public Reservation(Payment payment, Status status, boolean isWeb) {
        this.payment = payment;
        this.status = status;
        this.isWeb = isWeb;
    }
    public Reservation(Medic medic, Pacient pacient, Payment payment, Status status, User user, String title, String note, String message, Date dateAt, Date timeAt, Date createdAt, String symtoms, String sick, String medicaments, Double price, boolean isWeb) {
       this.medic = medic;
       this.pacient = pacient;
       this.payment = payment;
       this.status = status;
       this.user = user;
       this.title = title;
       this.note = note;
       this.message = message;
       this.dateAt = dateAt;
       this.timeAt = timeAt;
       this.createdAt = createdAt;
       this.symtoms = symtoms;
       this.sick = sick;
       this.medicaments = medicaments;
       this.price = price;
       this.isWeb = isWeb;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Medic getMedic() {
        return this.medic;
    }
    
    public void setMedic(Medic medic) {
        this.medic = medic;
    }
    public Pacient getPacient() {
        return this.pacient;
    }
    
    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }
    public Payment getPayment() {
        return this.payment;
    }
    
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    public Status getStatus() {
        return this.status;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    public Date getDateAt() {
        return this.dateAt;
    }
    
    public void setDateAt(Date dateAt) {
        this.dateAt = dateAt;
    }
    public Date getTimeAt() {
        return this.timeAt;
    }
    
    public void setTimeAt(Date timeAt) {
        this.timeAt = timeAt;
    }
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public String getSymtoms() {
        return this.symtoms;
    }
    
    public void setSymtoms(String symtoms) {
        this.symtoms = symtoms;
    }
    public String getSick() {
        return this.sick;
    }
    
    public void setSick(String sick) {
        this.sick = sick;
    }
    public String getMedicaments() {
        return this.medicaments;
    }
    
    public void setMedicaments(String medicaments) {
        this.medicaments = medicaments;
    }
    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    public boolean isIsWeb() {
        return this.isWeb;
    }
    
    public void setIsWeb(boolean isWeb) {
        this.isWeb = isWeb;
    }




}


