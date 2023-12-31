package reportgenerator.models;

public class Report {
    private final String title;
    private final String subTitle;
    private final String content;
    private final String footer;

    private Report(Builder builder) {
        this.title = builder.title;
        this.subTitle = builder.subTitle;
        this.content = builder.content;
        this.footer = builder.footer;
    }

    public static class Builder {
        private String title = "";
        private String subTitle = "";
        private String content = "";
        private String footer = "";

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder subTitle(String subTitle) {
            this.subTitle = subTitle;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder footer(String footer) {
            this.footer = footer;
            return this;
        }

        public Report build() {
            return new Report(this);
        }
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getContent() {
        return content;
    }

    public String getFooter() {
        return footer;
    }
}
