import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class excel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fileToBeRead = "file\\data.xls";
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(fileToBeRead)); // ������Excel�������ļ�������
            HSSFSheet sheet = workbook.getSheet("Sheet1");  // �����Թ����������
            int rows = sheet.getPhysicalNumberOfRows();//��ȡ����
            for (int r = 0; r < rows; r++) {                //ѭ������������
                String value = "";
                HSSFRow row = sheet.getRow(r);         //��ȡ��Ԫ����ָ�����ж���
                if (row != null) {
                    int cells = row.getPhysicalNumberOfCells();//��ȡ��Ԫ����ָ���ж���
                    for (short c = 0; c < cells; c++) {      //ѭ��������Ԫ���е���                  
                        HSSFCell cell = row.getCell((short) c); //��ȡָ����Ԫ���е���                      
                        if (cell != null) {
                            if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {  //�жϵ�Ԫ���ֵ�Ƿ�Ϊ�ַ�������                                
                                value += cell.getStringCellValue() + ",";
                            } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {  //�жϵ�Ԫ���ֵ�Ƿ�Ϊ��������                                
                                value += cell.getNumericCellValue() + ",";
                            } else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {    //�жϵ�Ԫ���ֵ�Ƿ�Ϊ��������                      
                                value += cell.getStringCellValue() + ",";
                            }
                        }
                    }
                }
                String[] str = value.split(",");
                System.out.println(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
