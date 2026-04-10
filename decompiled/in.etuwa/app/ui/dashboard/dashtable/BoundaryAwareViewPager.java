package in.etuwa.app.ui.dashboard.dashtable;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoundaryAwareViewPager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BoundaryAwareViewPager extends ViewPager {
    private final int SWIPE_THRESHOLD;
    private BoundaryCallback boundaryCallback;
    private float downX;
    private boolean isAtEnd;
    private boolean isAtStart;

    /* JADX INFO: compiled from: BoundaryAwareViewPager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/dashboard/dashtable/BoundaryAwareViewPager$BoundaryCallback;", "", "onSwipePastEnd", "", "onSwipePastStart", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface BoundaryCallback {
        void onSwipePastEnd();

        void onSwipePastStart();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BoundaryAwareViewPager(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BoundaryAwareViewPager(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoundaryAwareViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.SWIPE_THRESHOLD = 60;
        addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() { // from class: in.etuwa.app.ui.dashboard.dashtable.BoundaryAwareViewPager.1
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
                boolean z = false;
                BoundaryAwareViewPager.this.isAtStart = position == 0;
                BoundaryAwareViewPager boundaryAwareViewPager = BoundaryAwareViewPager.this;
                PagerAdapter adapter = boundaryAwareViewPager.getAdapter();
                if (adapter != null) {
                    z = position == adapter.getCount() - 1;
                }
                boundaryAwareViewPager.isAtEnd = z;
            }
        });
    }

    public final BoundaryCallback getBoundaryCallback() {
        return this.boundaryCallback;
    }

    public final void setBoundaryCallback(BoundaryCallback boundaryCallback) {
        this.boundaryCallback = boundaryCallback;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        int action = ev.getAction();
        if (action == 0) {
            this.downX = ev.getX();
        } else if (action == 1) {
            float x = ev.getX() - this.downX;
            if (x > this.SWIPE_THRESHOLD && this.isAtStart) {
                BoundaryCallback boundaryCallback = this.boundaryCallback;
                if (boundaryCallback != null) {
                    boundaryCallback.onSwipePastStart();
                }
                return true;
            }
            if (x < (-r2) && this.isAtEnd) {
                BoundaryCallback boundaryCallback2 = this.boundaryCallback;
                if (boundaryCallback2 != null) {
                    boundaryCallback2.onSwipePastEnd();
                }
                return true;
            }
        }
        return super.onTouchEvent(ev);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getAction() == 0) {
            this.downX = ev.getX();
        }
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }
}