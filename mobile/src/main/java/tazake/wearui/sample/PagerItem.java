package tazake.wearui.sample;

public class PagerItem {
    private String mName;
    private String mDescription;
    private int mImageResourceId;
    private int mBackgroundResourceId;

    public PagerItem(String name, String description, int imageResourceId, int backgroundResourceId) {
        mName = name;
        mDescription = description;
        mImageResourceId = imageResourceId;
        mBackgroundResourceId = backgroundResourceId;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getBackgroundResourceId() {
        return mBackgroundResourceId;
    }
}