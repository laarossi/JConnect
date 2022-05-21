package http.header.cache;

public class CacheBuilder {

    private Cache cache = new Cache();

    public static CacheBuilder cache(){
        return new CacheBuilder();
    }

    public CacheBuilder publicCache(){
        cache.cacheControlType = Cache.CacheControlType.PUBLIC;
        return this;
    }

    public CacheBuilder privateCache(){
        cache.cacheControlType = Cache.CacheControlType.PRIVATE;
        return this;
    }

    public CacheBuilder revalidate(){
        cache.cacheControlType = Cache.CacheControlType.MUST_REVALIDATE;
        return this;
    }

    public CacheBuilder noStore(){
        cache.cacheControlType = Cache.CacheControlType.NO_STORE;
        return this;
    }

    public CacheBuilder noCache(){
        cache.cacheControlType = Cache.CacheControlType.NO_CACHE;
        return this;
    }

    public CacheBuilder cacheType(Cache.CacheControlType type){
        cache.cacheControlType = type;
        return this;
    }

    public CacheBuilder maxAge(int maxAge){
        cache.setMaxAge(maxAge);
        return this;
    }

    public CacheBuilder eTag(String tag){
        cache.setETag(tag);
        return this;
    }

    public Cache build(){
        return this.cache;
    }

}
