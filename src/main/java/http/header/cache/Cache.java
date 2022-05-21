package http.header.cache;

import java.time.LocalDateTime;

public class Cache {

    int maxAge;
    String ETag;
    CacheControlType cacheControlType = CacheControlType.PUBLIC;

    enum CacheControlType{

        NO_CACHE("no-cache"), NO_STORE("no-store"), MUST_REVALIDATE("must-revalidate"),
        PRIVATE("private"), PUBLIC("public");

        String type;
        CacheControlType(String type){
            this.type = type;
        }

    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public String getETag() {
        return ETag;
    }

    public void setETag(String eTag) {
        this.ETag = eTag;
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cache-Control : ");
        stringBuilder.append(cacheControlType.type);
        if(maxAge != 0){
            stringBuilder.append(", ").append("max-age=").append(maxAge);
        }
        return stringBuilder.toString();
    }

}

