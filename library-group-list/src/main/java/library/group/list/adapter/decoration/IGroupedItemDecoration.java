package library.group.list.adapter.decoration;

import android.graphics.drawable.Drawable;

import androidx.recyclerview.widget.RecyclerView;

public interface IGroupedItemDecoration {

    int getHeaderDividerSize(int groupPosition);

    Drawable getHeaderDivider(int groupPosition);

    int getFooterDividerSize(int groupPosition);

    Drawable getFooterDivider(int groupPosition);

    int getChildColumnDividerSize(int groupPosition, int childPosition);

    Drawable getChildColumnDivider(int groupPosition, int childPosition);

    int getChildRowDividerSize(int groupPosition, int childPosition);

    Drawable getChildRowDivider(int groupPosition, int childPosition);

    /**
     * 检测是否是可支持的LayoutManager
     *
     * @param view
     * @return
     */
    boolean checkLayoutManager(RecyclerView view);

}
