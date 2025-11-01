package in.etuwa.app.helper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WrapContentViewPager.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0014¨\u0006\u000e"}, d2 = {"Lin/etuwa/app/helper/WrapContentViewPager;", "Landroidx/viewpager/widget/ViewPager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "initPageChangeListener", "", "onMeasure", "widthMeasureSpec", "", "heightMeasureSpece", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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
        addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() { // from class: in.etuwa.app.helper.WrapContentViewPager$initPageChangeListener$1
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