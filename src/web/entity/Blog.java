package web.entity;

/**
* @ClassName: Blog
* @Description: 博客实体类
* @author 李勇超
* @date 2018年12月27日下午5:19:50
*
*/
public class Blog {
	private int id;
	private String title;
	private int tag;
	private String content;
	private String lastTime;
	private int status;
	private int good;
	private int readNum;
	private int uid;
	
	public Blog() {	}

	public Blog(int id,String title, int tag, String content,int status) {
		super();
		this.id=id;
		this.title = title;
		this.tag = tag;
		this.content = content;
		this.status = status;
	}
	
	public Blog(String title, int tag, String content) {
		super();
		this.title = title;
		this.tag = tag;
		this.content = content;
	}
	
	public Blog(String title, int tag, String content,int uid,int status) {
		super();
		this.title = title;
		this.tag = tag;
		this.content = content;
		this.uid = uid;
		this.status = status;
	}

	public Blog(int id, String title, int tag, String content, String lastTime, int status, int good, int readNum,
			int uid) {
		super();
		this.id = id;
		this.title = title;
		this.tag = tag;
		this.content = content;
		this.lastTime = lastTime;
		this.status = status;
		this.good = good;
		this.readNum = readNum;
		this.uid = uid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public int getReadNum() {
		return readNum;
	}

	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
}
