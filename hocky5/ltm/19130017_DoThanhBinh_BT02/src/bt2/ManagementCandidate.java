package bt2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class ManagementCandidate {
	class CandidateEntry {
		String id;
		int age;
		String linkCV;
		long size;
		long position;

		public CandidateEntry(String id, int age, String linkCV, long size, long position) {
			super();
			this.id = id;
			this.age = age;
			this.linkCV = linkCV;
			this.size = size;
			this.position = position;
		}

	}

	public void saveInfo(ArrayList<Candidate> listCan, String destFile) throws IOException {
		// initial
		ArrayList<CandidateEntry> header = new ArrayList<CandidateEntry>();
		RandomAccessFile raf = new RandomAccessFile(destFile, "rw");
		int byteRead;
		byte[] data = new byte[1024 * 100];
		BufferedInputStream bis;

		// write
		for (Candidate candidate : listCan) {
			// initial
			File fileCV = new File(candidate.getLinkCV());
			if (fileCV.isDirectory()) {
				System.err.println("CV is file, not directory.");
				return;
			}
			bis = new BufferedInputStream(new FileInputStream(fileCV));

			// save header
			header.add(new CandidateEntry(candidate.getId(), candidate.getAge(), candidate.getLinkCV(), fileCV.length(),
					raf.getFilePointer()));

			// write file CV
			while ((byteRead = bis.read(data)) != -1) {
				raf.write(data, 0, byteRead);
			}
			// close bis
			bis.close();
		}

		long headerPossition = raf.getFilePointer();
		raf.writeInt(listCan.size()); // write length candidates

		// save header
		for (CandidateEntry candidateEntry : header) {
			raf.writeUTF(candidateEntry.id);
			raf.writeInt(candidateEntry.age);
			raf.writeUTF(candidateEntry.linkCV);
			raf.writeLong(candidateEntry.size);
			raf.writeLong(candidateEntry.position);
		}

		// save position header
		raf.writeLong(headerPossition);

		// close raf
		raf.close();

	}

	public void getCVById(String sourceFile, String idCan, String destFolder) throws IOException {
		// check
		File source = new File(sourceFile);
		if (!source.exists() || source.isDirectory()) {
			System.err.println("Not File Exeception");
			return;
		}
		File dest = new File(destFolder);
		if (!dest.exists()) {
			return;
		}

		// initial raf
		RandomAccessFile raf = new RandomAccessFile(source, "rw");

		// get position header
		long currentPosition = raf.length() - 8;
		raf.seek(currentPosition);

		// read header
		long headerPosition = raf.readLong();
		raf.seek(headerPosition);

		// read length candidates
		int numCandidates = raf.readInt();
		ArrayList<CandidateEntry> header = new ArrayList<CandidateEntry>();

		// read header
		for (int i = 0; i < numCandidates; i++) {
			header.add(new CandidateEntry(raf.readUTF(), raf.readInt(), raf.readUTF(), raf.readLong(), raf.readLong()));
		}

		// read candidate
		BufferedOutputStream bos;
		for (CandidateEntry candidateEntry : header) {
			if (idCan.equals(candidateEntry.id)) {
				// get name cv
				String nameCV = getNameCV(candidateEntry.linkCV);
				raf.seek(candidateEntry.position);

				// initial
				bos = new BufferedOutputStream(new FileOutputStream(dest + "\\" + nameCV));

				// write into destFolder
				if (fileTransfer(raf, bos, candidateEntry.size)) {
					// close stream
					bos.close();
					raf.close();
					break;
				}
			}
		}
	}

	private boolean fileTransfer(RandomAccessFile raf, OutputStream bos, long size) throws IOException {
		long remain = size;
		int byteRead;
		byte[] data = new byte[1024 * 100];
		int requestNumber = (int) ((remain > data.length) ? data.length : remain);

		while ((byteRead = raf.read(data, 0, requestNumber)) != -1) {
			bos.write(data, 0, byteRead);
			remain -= byteRead;
			requestNumber = (int) ((remain > data.length) ? data.length : remain);
			if (requestNumber < 1)
				return true;
		}
		return false;
	}

	public String getNameCV(String linkCV) {
		return linkCV.substring(linkCV.lastIndexOf("\\") + 1);
	}

	public void getCVByAge(String sourceFile, int ageCan, String destFolder) throws IOException {
		// check
		File source = new File(sourceFile);
		if (!source.exists() || source.isDirectory()) {
			System.err.println("Not File Exeception");
			return;
		}

		File dest = new File(destFolder);
		if (!dest.exists()) {
			return;
		}

		// initial raf
		RandomAccessFile raf = new RandomAccessFile(source, "rw");

		// get position header
		long currentPosition = raf.length() - 8;
		raf.seek(currentPosition);

		// read header
		long headerPosition = raf.readLong();
		raf.seek(headerPosition);

		// read length candidates
		int numCandidates = raf.readInt();
		ArrayList<CandidateEntry> header = new ArrayList<CandidateEntry>();

		// read header
		for (int i = 0; i < numCandidates; i++) {
			header.add(new CandidateEntry(raf.readUTF(), raf.readInt(), raf.readUTF(), raf.readLong(), raf.readLong()));
		}

		// read candidate
		BufferedOutputStream bos;
		for (CandidateEntry candidateEntry : header) {
			if (ageCan == candidateEntry.age) {
				// get name cv
				String nameCV = getNameCV(candidateEntry.linkCV);
				raf.seek(candidateEntry.position);

				// initial
				bos = new BufferedOutputStream(new FileOutputStream(dest + "\\" + nameCV));

				// write into destFolder
				if (fileTransfer(raf, bos, candidateEntry.size)) {
					bos.close();
				}
			}
		}
		// close raf
		raf.close();
	}

	public static void main(String[] args) throws IOException {
		ManagementCandidate man = new ManagementCandidate();
		Candidate c1 = new Candidate("TS01", "Võ Tấn Toàn", 40, "E:\\Test\\TS01CV.pdf");
		Candidate c2 = new Candidate("TS02", "Đỗ Thanh Bình", 40, "E:\\Test\\TS02CV.pdf");
		Candidate c3 = new Candidate("TS03", "Nguyễn Văn A", 20, "E:\\Test\\TS03CV.pdf");

		ArrayList<Candidate> listCan = new ArrayList<Candidate>();
		listCan.add(c1);
		listCan.add(c2);
		listCan.add(c3);
 
		// save info
		String destFile = "E:\\Test\\Client1\\Catedidates.txt";
		man.saveInfo(listCan, destFile);

		// get cv by id
//		String sourceFile = "E:\\Test1\\Catedidates.cv";
//		String destFolder = "E:\\Test2";
//		String idCan = "TS02";

//		 man.getCVById(sourceFile, idCan, destFolder);

		// get cv by age
//		int age = 40;
//		man.getCVByAge(sourceFile, age, destFolder);
	}
}
