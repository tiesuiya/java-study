package org.lhpsn.thirdparty.lucene4.dto;

/**
 * 索引DTO
 *
 * @author lh
 * @since 1.0.0
 */
public class IndexDTO {

    /**
     * id
     */
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String contents;

    /**
     * 文件地址
     */
    private String fileUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public String toString() {
        return "IndexDTO{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                '}';
    }
}
