package edu.mass.doe.cap.dataservice.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Where;




@Entity
@Table(name = "CP069FUS_FILE_UPLOAD_STAGING")
@AttributeOverrides({
@AttributeOverride(name = "createDate", column = @Column(name = "FUS_CREATE_DATE")),
@AttributeOverride(name = "createUser", column = @Column(name = "FUS_CREATED_BY")),
@AttributeOverride(name = "modifyDate", column = @Column(name = "FUS_UPDATE_DATE")),
@AttributeOverride(name = "modifyUser", column = @Column(name = "FUS_UPDATED_BY"))
})
public class BatchStaging  extends BaseJPAEntity{
	
	@Id
	@Column(name="FUS_FILE_STAGING_ID")
	@SequenceGenerator(name = "FUS_PK_GENERATOR", sequenceName = "CP069FUS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FUS_PK_GENERATOR")
	private Long stagingId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FUS_FILE_UPLOAD_ID", insertable = true, updatable = false,nullable=false)
	private Batch batch;	
	
	@Column(name="FUS_ORGANIZATION_NM")
	private String col0;
	
	@Column(name="FUS_PRACT_DISTRICT_NAME")
	private String col1;
	
	@Column(name="FUS_PRACT_SCHOOL_NAME")
	private String col2;
	
	@Column(name="FUS_SCH_YEAR")
	private String col3;
	
	@Column(name="FUS_PROGRAM_NAME")
	private String col4;
	
	@Column(name="FUS_CAND_MEPID")
	private String col5;
	
	@Column(name="FUS_CAND_FIRST_NAME")
	private String col6;
	
	@Column(name="FUS_CAND_LAST_NAME")
	private String col7;
	
	@Column(name="FUS_CAND_EMAIL")
	private String col8;
	
		
	@Column(name="FUS_PS_NAME")
	private String col9;
	
	@Column(name="FUS_PS_EMAIL")
	private String col10;
	
	@Column(name="FUS_SP_MEPID")
	private String col12;
	
	@Column(name="FUS_SP_NAME")
	private String col11;
	
	@Column(name="FUS_SP_FIRST_NAME")
	private String col13;
	
	@Column(name="FUS_SP_LAST_NAME")
	private String col14;
	
	@Column(name="FUS_SP_EMAIL")
	private String col15;
	
	@Column(name="FUS_F1A4Q")
	private String col16;
	
	@Column(name="FUS_F1A4S")
	private String col17;
	
	@Column(name="FUS_F1A4C")
	private String col18;
	
	@Column(name="FUS_F1B2Q")
	private String col19;
	
	@Column(name="FUS_F1B2S")
	private String col20;
	
	@Column(name="FUS_F1B2C")
	private String col21;
	
	@Column(name="FUS_F2A3Q")
	private String col22;
	
	@Column(name="FUS_F2A3S")
	private String col23;
	
	@Column(name="FUS_F2A3C")
	private String col24;
	
	@Column(name="FUS_F2B1Q")
	private String col25;
	
	@Column(name="FUS_F2B1S")
	private String col26;
	
	@Column(name="FUS_F2B1C")
	private String col27;
	
	@Column(name="FUS_F2D2Q")
	private String col28;
	
	@Column(name="FUS_F2D2S")
	private String col29;
	
	@Column(name="FUS_F2D2C")
	private String col30;
	
	@Column(name="FUS_F4A1Q")
	private String col31;
	
	@Column(name="FUS_F4A1S")
	private String col32;
	
	@Column(name="FUS_F4A1C")
	private String col33;
	
	@Column(name="FUS_S1A4Q")
	private String col34;
	
	@Column(name="FUS_S1A4S")
	private String col35;
	
	@Column(name="FUS_S1A4C")
	private String col36;
	
	@Column(name="FUS_S1B2Q")
	private String col37;
	
	@Column(name="FUS_S1B2S")
	private String col38;
	
	@Column(name="FUS_S1B2C")
	private String col39;
	
	@Column(name="FUS_S2A3Q")
	private String col40;
	
	@Column(name="FUS_S2A3S")
	private String col41;
	
	@Column(name="FUS_S2A3C")
	private String col42;
	
	@Column(name="FUS_S2B1Q")
	private String col43;
	
	@Column(name="FUS_S2B1S")
	private String col44;
	
	@Column(name="FUS_S2B1C")
	private String col45;
	
	@Column(name="FUS_S2D2Q")
	private String col46;
	
	@Column(name="FUS_S2D2S")
	private String col47;
	
	@Column(name="FUS_S2D2C")
	private String col48;
	
	@Column(name="FUS_S4A1Q")
	private String col49;
	
	@Column(name="FUS_S4A1S")
	private String col50;
	
	@Column(name="FUS_S4A1C")
	private String col51;
	
	@Column(name="FUS_READY_TO_TEACH")
	private String col52;
	
	@Column(name="FUS_EXP_DATE")
	private Date expDate;
	
	@Column(name="FUS_EFF_DATE")
	private Date effDate;
	
	
	@OneToMany(mappedBy = "batchStaging", cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	@Where(clause = "FUE_EXP_DATE is null")
	private List<BatchError> errors;

	public Long getStagingId() {
		return stagingId;
	}

	public void setStagingId(Long stagingId) {
		this.stagingId = stagingId;
	}

	
	public String getCol0() {
		return col0;
	}

	public void setCol0(String col0) {
		this.col0 = col0;
	}

	public String getCol1() {
		return col1;
	}

	public void setCol1(String col1) {
		this.col1 = col1;
	}

	public String getCol2() {
		return col2;
	}

	public void setCol2(String col2) {
		this.col2 = col2;
	}

	public String getCol3() {
		return col3;
	}

	public void setCol3(String col3) {
		this.col3 = col3;
	}

	public String getCol4() {
		return col4;
	}

	public void setCol4(String col4) {
		this.col4 = col4;
	}

	public String getCol5() {
		return col5;
	}

	public void setCol5(String col5) {
		this.col5 = col5;
	}

	public String getCol6() {
		return col6;
	}

	public void setCol6(String col6) {
		this.col6 = col6;
	}

	public String getCol7() {
		return col7;
	}

	public void setCol7(String col7) {
		this.col7 = col7;
	}

	public String getCol8() {
		return col8;
	}

	public void setCol8(String col8) {
		this.col8 = col8;
	}

	public String getCol9() {
		return col9;
	}

	public void setCol9(String col9) {
		this.col9 = col9;
	}

	public String getCol10() {
		return col10;
	}

	public void setCol10(String col10) {
		this.col10 = col10;
	}

	public String getCol11() {
		return col11;
	}

	public void setCol11(String col11) {
		this.col11 = col11;
	}

	public String getCol12() {
		return col12;
	}

	public void setCol12(String col12) {
		this.col12 = col12;
	}

	public String getCol13() {
		return col13;
	}

	public void setCol13(String col13) {
		this.col13 = col13;
	}

	public String getCol14() {
		return col14;
	}

	public void setCol14(String col14) {
		this.col14 = col14;
	}

	public String getCol15() {
		return col15;
	}

	public void setCol15(String col15) {
		this.col15 = col15;
	}

	public String getCol16() {
		return col16;
	}

	public void setCol16(String col16) {
		this.col16 = col16;
	}

	public String getCol17() {
		return col17;
	}

	public void setCol17(String col17) {
		this.col17 = col17;
	}

	public String getCol18() {
		return col18;
	}

	public void setCol18(String col18) {
		this.col18 = col18;
	}

	public String getCol19() {
		return col19;
	}

	public void setCol19(String col19) {
		this.col19 = col19;
	}

	public String getCol20() {
		return col20;
	}

	public void setCol20(String col20) {
		this.col20 = col20;
	}

	public String getCol21() {
		return col21;
	}

	public void setCol21(String col21) {
		this.col21 = col21;
	}

	public String getCol22() {
		return col22;
	}

	public void setCol22(String col22) {
		this.col22 = col22;
	}

	public String getCol23() {
		return col23;
	}

	public void setCol23(String col23) {
		this.col23 = col23;
	}

	public String getCol24() {
		return col24;
	}

	public void setCol24(String col24) {
		this.col24 = col24;
	}

	public String getCol25() {
		return col25;
	}

	public void setCol25(String col25) {
		this.col25 = col25;
	}

	public String getCol26() {
		return col26;
	}

	public void setCol26(String col26) {
		this.col26 = col26;
	}

	public String getCol27() {
		return col27;
	}

	public void setCol27(String col27) {
		this.col27 = col27;
	}

	public String getCol28() {
		return col28;
	}

	public void setCol28(String col28) {
		this.col28 = col28;
	}

	public String getCol29() {
		return col29;
	}

	public void setCol29(String col29) {
		this.col29 = col29;
	}

	public String getCol30() {
		return col30;
	}

	public void setCol30(String col30) {
		this.col30 = col30;
	}

	public String getCol31() {
		return col31;
	}

	public void setCol31(String col31) {
		this.col31 = col31;
	}

	public String getCol32() {
		return col32;
	}

	public void setCol32(String col32) {
		this.col32 = col32;
	}

	public String getCol33() {
		return col33;
	}

	public void setCol33(String col33) {
		this.col33 = col33;
	}

	public String getCol34() {
		return col34;
	}

	public void setCol34(String col34) {
		this.col34 = col34;
	}

	public String getCol35() {
		return col35;
	}

	public void setCol35(String col35) {
		this.col35 = col35;
	}

	public String getCol36() {
		return col36;
	}

	public void setCol36(String col36) {
		this.col36 = col36;
	}

	public String getCol37() {
		return col37;
	}

	public void setCol37(String col37) {
		this.col37 = col37;
	}

	public String getCol38() {
		return col38;
	}

	public void setCol38(String col38) {
		this.col38 = col38;
	}

	public String getCol39() {
		return col39;
	}

	public void setCol39(String col39) {
		this.col39 = col39;
	}

	public String getCol40() {
		return col40;
	}

	public void setCol40(String col40) {
		this.col40 = col40;
	}

	public String getCol41() {
		return col41;
	}

	public void setCol41(String col41) {
		this.col41 = col41;
	}

	public String getCol42() {
		return col42;
	}

	public void setCol42(String col42) {
		this.col42 = col42;
	}

	public String getCol43() {
		return col43;
	}

	public void setCol43(String col43) {
		this.col43 = col43;
	}

	public String getCol44() {
		return col44;
	}

	public void setCol44(String col44) {
		this.col44 = col44;
	}

	public String getCol45() {
		return col45;
	}

	public void setCol45(String col45) {
		this.col45 = col45;
	}

	public String getCol46() {
		return col46;
	}

	public void setCol46(String col46) {
		this.col46 = col46;
	}

	public String getCol47() {
		return col47;
	}

	public void setCol47(String col47) {
		this.col47 = col47;
	}

	public String getCol48() {
		return col48;
	}

	public void setCol48(String col48) {
		this.col48 = col48;
	}

	public String getCol49() {
		return col49;
	}

	public void setCol49(String col49) {
		this.col49 = col49;
	}

	public String getCol50() {
		return col50;
	}

	public void setCol50(String col50) {
		this.col50 = col50;
	}

	public String getCol51() {
		return col51;
	}

	public void setCol51(String col51) {
		this.col51 = col51;
	}

	public String getCol52() {
		return col52;
	}

	public void setCol52(String col52) {
		this.col52 = col52;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public Date getEffDate() {
		return effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	public List<BatchError> getErrors() {
		return errors;
	}

	public void setErrors(List<BatchError> errors) {
		this.errors = errors;
	}
	

}