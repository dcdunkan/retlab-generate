package in.etuwa.app.helper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WrapContentViewPager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class WrapContentViewPager extends ViewPager {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WrapContentViewPager(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initPageChangeListener();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WrapContentViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        initPageChangeListener();
    }

    private final void initPageChangeListener() {
        addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() { // from class: in.etuwa.app.helper.WrapContentViewPager.initPageChangeListener.1
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
                WrapContentViewPager.this.requestLayout();
            }
        });
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpece) {
        int mode = View.MeasureSpec.getMode(heightMeasureSpece);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpece);
            int childCount = getChildCount();
            int i = 0;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                childAt.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i) {
                    i = measuredHeight;
                }
            }
            heightMeasureSpece = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpece);
    }
}