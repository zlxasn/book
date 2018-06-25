package org.itzxs.entity;

public class QidianType {
    private Integer id;

    private Integer typeCode;

    private Integer parentId;

    private String typeName;

    private String typeUrl;

    private Integer typeLevel;

    public QidianType() {
    }

    public QidianType(Integer typeCode, Integer parentId, String typeName, String typeUrl, Integer typeLevel) {
        this.typeCode = typeCode;
        this.parentId = parentId;
        this.typeName = typeName;
        this.typeUrl = typeUrl;
        this.typeLevel = typeLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getTypeUrl() {
        return typeUrl;
    }

    public void setTypeUrl(String typeUrl) {
        this.typeUrl = typeUrl == null ? null : typeUrl.trim();
    }

    public Integer getTypeLevel() {
        return typeLevel;
    }

    public void setTypeLevel(Integer typeLevel) {
        this.typeLevel = typeLevel;
    }
}