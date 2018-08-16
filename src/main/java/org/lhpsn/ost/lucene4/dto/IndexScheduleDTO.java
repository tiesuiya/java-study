package org.lhpsn.ost.lucene4.dto;

/**
 * 索引进度DTO
 *
 * @author lh
 * @since 1.0.0
 */
public class IndexScheduleDTO {

    /**
     * 状态
     */
    private Integer status;

    /**
     * 当前完成条数
     */
    private Integer finishNum;

    /**
     * 总条数
     */
    private Integer totalNum;

    public IndexScheduleDTO() {
    }

    public IndexScheduleDTO(Integer status, Integer finishNum, Integer totalNum) {
        this.status = status;
        this.finishNum = finishNum;
        this.totalNum = totalNum;
    }

    /**
     * 进度状态枚举
     */
    public enum StatusEnum {

        /**
         * 空闲
         */
        IDLE(0, "空闲"),

        /**
         * 运行中
         */
        RUNNING(1, "运行中");

        private Integer state;
        private String comments;

        StatusEnum(Integer state, String comments) {
            this.state = state;
            this.comments = comments;
        }

        public static StatusEnum stateOf(Integer state) {
            for (StatusEnum issuesStatusEnum : values()) {
                if (issuesStatusEnum.getState().equals(state)) {
                    return issuesStatusEnum;
                }
            }
            return null;
        }

        public String getComments() {
            return comments;
        }

        public Integer getState() {
            return state;
        }
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFinishNum() {
        return finishNum;
    }

    public void setFinishNum(Integer finishNum) {
        this.finishNum = finishNum;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    @Override
    public String toString() {
        return "IndexScheduleDTO{" +
                "status=" + status +
                ", finishNum=" + finishNum +
                ", totalNum=" + totalNum +
                '}';
    }
}
