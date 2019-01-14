package humor_developer;

import java.sql.Date;

	public class Subject {

	private int subjectid = 0;

	private String title = null;

	private String content = null;

	private String linkurl = null;

	private int category1 = 0;

	private int category2 = 0;

	private int category3 = 0;

	private Date modified = null;

	public int getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLinkurl() {
		return linkurl;
	}

	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}

	public int getCategory1() {
		return category1;
	}

	public void setCategory1(int category1) {
		this.category1 = category1;
	}

	public int getCategory2() {
		return category2;
	}

	public void setCategory2(int category2) {
		this.category2 = category2;
	}

	public int getCategory3() {
		return category3;
	}

	public void setCategory3(int category3) {
		this.category3 = category3;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}
}
