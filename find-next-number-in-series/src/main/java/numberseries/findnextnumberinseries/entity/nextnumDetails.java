package numberseries.findnextnumberinseries.entity;

public class nextnumDetails {

		Double nextNum;
		String nameOfSeries;
		String logicalFlow;

		
		public nextnumDetails(Double nextNum, String nameOfSeries, String logicalFlow) {
			this.nextNum = nextNum;
			this.nameOfSeries = nameOfSeries;
			this.logicalFlow = logicalFlow;
		}
		
		public Double getNextNum() {
			return nextNum;
		}
		public void setNextNum(Double nextNum) {
			this.nextNum = nextNum;
		}
		public String getNameOfSeries() {
			return nameOfSeries;
		}
		public void setNameOfSeries(String nameOfSeries) {
			this.nameOfSeries = nameOfSeries;
		}
		public String getLogicalFlow() {
			return logicalFlow;
		}
		public void setLogicalFlow(String logicalFlow) {
			this.logicalFlow = logicalFlow;
		}
	}
