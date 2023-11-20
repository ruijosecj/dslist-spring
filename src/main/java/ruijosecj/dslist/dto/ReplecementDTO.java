package ruijosecj.dslist.dto;

public class ReplecementDTO {
	private Integer sourceIndex;
	private Integer destinatonIndex;
	
	public ReplecementDTO() {}

	public ReplecementDTO(Integer sourceIndex, Integer destinatonIndex) {
		super();
		this.sourceIndex = sourceIndex;
		this.destinatonIndex = destinatonIndex;
	}

	public Integer getSourceIndex() {
		return sourceIndex;
	}

	public void setSourceIndex(Integer sourceIndex) {
		this.sourceIndex = sourceIndex;
	}

	public Integer getDestinatonIndex() {
		return destinatonIndex;
	}

	public void setDestinatonIndex(Integer destinatonIndex) {
		this.destinatonIndex = destinatonIndex;
	}
	
}
