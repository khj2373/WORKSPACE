package test240711.object3;

public class Book {
	private String name;
	private String genre;
	private String author;
	private int bNo;
	
	public Book() {
		
	}
	
	public Book(String name, String genre, String author, int bNo) {
		super();
		this.name = name;
		this.genre = genre;
		this.author = author;
		this.bNo = bNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	
	public String toString() {
//		System.out.println("제목 : " + this.name);
//		System.out.println("장르 : " + this.genre);
//		System.out.println("저자 : " + this.author);
//		System.out.println("책 번호 : " + this.bNo);
		return "제목 : " + this.name + " 장르 : " + this.genre + " 저자 : " + this.author + " 책 번호 : " + this.bNo;
	}

}
