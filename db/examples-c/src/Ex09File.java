import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09File {

	public static void main(String[] args) {
		
		// File : ���� �Ǵ� ���͸� ������ �����ϴ� Ŭ����
		
		//C:\Windows ���͸��� �����ϴ� ��ü �����
		File winDir = new File("C:\\Windows") ;
		
		// isDirectory : ���͸� ���� Ȯ�� , isFile() : ���� ���� Ȯ��
		//if (winDir.isDirectory() == false) { //isDirectory() : ���͸���� true ��ȯ
		if ( !winDir.isDirectory() ) { //! : ������������ -> !true == false / !false == true
			System.out.println("�������� ���͸�(����)�� �ƴմϴ�.");
			return;
		}
		
		//winDir ��ü�� �����ϴ� ���͸��� ���Ե� ��� ���� �� ���͸��� ���� ��ü�� ��Ƽ� �迭�� ��ȯ 
		File[] filesOrDirs = winDir.listFiles();
		for (File fileOrDir : filesOrDirs) { // ��ȸ : ����� ó������ ������ �� ���� ���������� ���
			//System.out.println(fileOrDir.getAbsolutePath()); // getAbsolutePath : ��ü ��� ��ȯ
			
			//�ð��� "2019-10-28 ���� 04:27" ������ ���ڿ��� ��ȯ�ϴ� ��ü �����
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
			//java.util.Date : ��¥�� �ð��� �����ϴ� Ŭ���� / ���⼭�� ����ð����� ��ü ����
			Date lastModified = new Date(fileOrDir.lastModified());
			
			if (fileOrDir.isDirectory()) { // ���͸��� ���
				System.out.printf("%s%7s%12s %s\n", 
								  f.format(lastModified), //������ ���� ����, ��¥ -> ���ڿ��� ��ȯ
								  "<DIR>",
								  "",
								  fileOrDir.getName()); // ������ �̸�
			} else { // ������ ���
				System.out.printf("%s%7s%,12d %s\n", 
						  		  f.format(lastModified), //������ ���� ����, ��¥ -> ���ڿ��� ��ȯ
						  		  "",
						  		  fileOrDir.length(), // ������ ũ�� (in byte)
						  		  fileOrDir.getName()); // ������ �̸�  
			}
		}
		
		
		
		
		

	}

}
