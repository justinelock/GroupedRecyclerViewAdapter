package library.group.list.adapter.decoration;

import android.graphics.drawable.Drawable;

import library.group.list.adapter.adapter.GroupedRecyclerViewAdapter;

public class GroupedLinearItemDecoration extends AbsGroupedLinearItemDecoration {

    private int mHeaderDividerSize;

    private Drawable mHeaderDivider;

    private int mFooterDividerSize;

    private Drawable mFooterDivider;

    private int mChildDividerSize;

    private Drawable mChildDivider;

    public GroupedLinearItemDecoration(GroupedRecyclerViewAdapter adapter,
                                       int headerDividerSize, Drawable headerDivider,
                                       int footerDividerSize, Drawable footerDivider,
                                       int childDividerSize, Drawable childDivider) {
        super(adapter);
        this.mHeaderDividerSize = headerDividerSize;
        this.mHeaderDivider = headerDivider;
        this.mFooterDividerSize = footerDividerSize;
        this.mFooterDivider = footerDivider;
        this.mChildDividerSize = childDividerSize;
        this.mChildDivider = childDivider;
    }

    @Override
    public int getChildDividerSize(int groupPosition, int ChildPosition) {
        return mChildDividerSize;
    }

    @Override
    public Drawable getChildDivider(int groupPosition, int ChildPosition) {
        return mChildDivider;
    }

    @Override
    public int getHeaderDividerSize(int groupPosition) {
        return mHeaderDividerSize;
    }

    @Override
    public Drawable getHeaderDivider(int groupPosition) {
        return mHeaderDivider;
    }

    @Override
    public int getFooterDividerSize(int groupPosition) {
        return mFooterDividerSize;
    }

    @Override
    public Drawable getFooterDivider(int groupPosition) {
        return mFooterDivider;
    }
}
