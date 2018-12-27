package edu.mass.doe.cap.dataservice.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import edu.mass.doe.cap.dataservice.pojo.CapData;

/**
 * The Class BatchDataMapper.
 */
public class BatchDataMapper implements FieldSetMapper<CapData> {

	/* (non-Javadoc)
	 * @see org.springframework.batch.item.file.mapping.FieldSetMapper#mapFieldSet(org.springframework.batch.item.file.transform.FieldSet)
	 */
	@Override
	public CapData mapFieldSet(FieldSet fieldSet) throws BindException {
		
		CapData capData = new CapData();
		capData.setCol0(fieldSet.readString(0));
		capData.setCol1(fieldSet.readString(1));
		capData.setCol2(fieldSet.readString(2));
		capData.setCol3(fieldSet.readString(3));
		capData.setCol4(fieldSet.readString(4));
		capData.setCol5(fieldSet.readString(5));
		capData.setCol6(fieldSet.readString(6));
		capData.setCol7(fieldSet.readString(7));
		capData.setCol8(fieldSet.readString(8));
		capData.setCol9(fieldSet.readString(9));
		capData.setCol10(fieldSet.readString(10));
		capData.setCol11(fieldSet.readString(11));
		capData.setCol12(fieldSet.readString(12));
		capData.setCol13(fieldSet.readString(13));
		capData.setCol14(fieldSet.readString(14));
		capData.setCol15(fieldSet.readString(15));
		capData.setCol16(fieldSet.readString(16));
		capData.setCol17(fieldSet.readString(17));
		capData.setCol18(fieldSet.readString(18));
		capData.setCol19(fieldSet.readString(19));
		capData.setCol20(fieldSet.readString(20));
		capData.setCol21(fieldSet.readString(21));
		capData.setCol22(fieldSet.readString(22));
		capData.setCol23(fieldSet.readString(23));
		capData.setCol24(fieldSet.readString(24));
		capData.setCol25(fieldSet.readString(25));
		capData.setCol26(fieldSet.readString(26));
		capData.setCol27(fieldSet.readString(27));
		capData.setCol28(fieldSet.readString(28));
		capData.setCol29(fieldSet.readString(29));
		capData.setCol30(fieldSet.readString(30));
		capData.setCol31(fieldSet.readString(31));
		capData.setCol32(fieldSet.readString(32));
		capData.setCol33(fieldSet.readString(33));
		capData.setCol34(fieldSet.readString(34));
		capData.setCol35(fieldSet.readString(35));
		capData.setCol36(fieldSet.readString(36));
		capData.setCol37(fieldSet.readString(37));
		capData.setCol38(fieldSet.readString(38));
		capData.setCol39(fieldSet.readString(39));
		capData.setCol40(fieldSet.readString(40));
		capData.setCol41(fieldSet.readString(41));
		capData.setCol42(fieldSet.readString(42));
		capData.setCol43(fieldSet.readString(43));
		capData.setCol44(fieldSet.readString(44));
		capData.setCol45(fieldSet.readString(45));
		capData.setCol46(fieldSet.readString(46));
		capData.setCol47(fieldSet.readString(47));
		capData.setCol48(fieldSet.readString(48));
		capData.setCol49(fieldSet.readString(49));
		capData.setCol50(fieldSet.readString(50));
		

		return capData;
	}

}
