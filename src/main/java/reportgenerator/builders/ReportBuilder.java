package reportgenerator.builders;

public class ReportBuilder {
    private final String fileFormat;
    private final String title;
    private final String subTitle;
    private final String content;
    private final String footer;

    private ReportBuilder(Builder builder){
        this.fileFormat = builder.fileFormat;
        this.title = builder.title;
        this.subTitle = builder.subTitle;
        this.content = builder.content;
        this.footer = builder.footer;
    }

    public static class Builder {
        private final String fileFormat;
        private String title = "";
        private String subTitle = "";
        private String content = "";
        private String footer = "";

        public Builder(String fileFormat){
            this.fileFormat = fileFormat;
        }
        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder subTitle(String subTitle){
            this.subTitle = subTitle;
            return this;
        }

        public Builder content(String content){
            this.content = content;
            return this;
        }

        public Builder footer(String footer){
            this.footer = footer;
            return this;
        }

        public ReportBuilder build(){
            return new ReportBuilder(this);
        }
    }

}
