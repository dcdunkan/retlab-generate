package in.etuwa.app.ui.hostel.attendance;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostelAttendanceAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class HostelAttendanceAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<Boolean> absent;
    private List<String> daysOfMonth;
    private List<Boolean> leaves;
    private int noOfDays;
    private List<Boolean> present;
    private List<Boolean> rejects;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(viewInflate);
        }
        if (viewType == 1) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_calendar_days, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …ndar_days, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i = this.noOfDays;
        if (i > 0) {
            return i;
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.noOfDays > 0 ? 1 : 0;
    }

    /* JADX INFO: compiled from: HostelAttendanceAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/ui/hostel/attendance/HostelAttendanceAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/hostel/attendance/HostelAttendanceAdapter;Landroid/view/View;)V", "dayMarker", "Landroid/widget/ImageView;", "getDayMarker", "()Landroid/widget/ImageView;", "tvDay", "Landroid/widget/TextView;", "getTvDay", "()Landroid/widget/TextView;", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final ImageView dayMarker;
        final /* synthetic */ HostelAttendanceAdapter this$0;
        private final TextView tvDay;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(HostelAttendanceAdapter hostelAttendanceAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = hostelAttendanceAdapter;
            View viewFindViewById = itemView.findViewById(R.id.tvDay);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "itemView.findViewById(R.id.tvDay)");
            this.tvDay = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.dayMarker);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "itemView.findViewById(R.id.dayMarker)");
            this.dayMarker = (ImageView) viewFindViewById2;
        }

        public final TextView getTvDay() {
            return this.tvDay;
        }

        public final ImageView getDayMarker() {
            return this.dayMarker;
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                List list = this.this$0.daysOfMonth;
                Intrinsics.checkNotNull(list);
                String str = (String) list.get(position);
                if (!Intrinsics.areEqual(str, "")) {
                    this.dayMarker.setVisibility(0);
                } else {
                    this.dayMarker.setVisibility(8);
                }
                this.tvDay.setText(str);
                if (Intrinsics.areEqual(str, "")) {
                    return;
                }
                List list2 = this.this$0.absent;
                Intrinsics.checkNotNull(list2);
                if (((Boolean) list2.get(position)).booleanValue()) {
                    List list3 = this.this$0.rejects;
                    Intrinsics.checkNotNull(list3);
                    if (((Boolean) list3.get(position)).booleanValue()) {
                        this.dayMarker.setBackgroundResource(R.drawable.reject_absent_hostel);
                        ViewGroup.LayoutParams layoutParams = this.dayMarker.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        marginLayoutParams.width = this.this$0.getDp(20);
                        marginLayoutParams.height = this.this$0.getDp(20);
                        marginLayoutParams.setMargins(this.this$0.getDp(0), this.this$0.getDp(0), this.this$0.getDp(0), this.this$0.getDp(0));
                        this.dayMarker.setLayoutParams(marginLayoutParams);
                        return;
                    }
                }
                List list4 = this.this$0.present;
                Intrinsics.checkNotNull(list4);
                if (((Boolean) list4.get(position)).booleanValue()) {
                    List list5 = this.this$0.rejects;
                    Intrinsics.checkNotNull(list5);
                    if (((Boolean) list5.get(position)).booleanValue()) {
                        this.dayMarker.setBackgroundResource(R.drawable.present_reject_hostel);
                        ViewGroup.LayoutParams layoutParams2 = this.dayMarker.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                        marginLayoutParams2.width = this.this$0.getDp(20);
                        marginLayoutParams2.height = this.this$0.getDp(20);
                        marginLayoutParams2.setMargins(this.this$0.getDp(0), this.this$0.getDp(0), this.this$0.getDp(0), this.this$0.getDp(0));
                        this.dayMarker.setLayoutParams(marginLayoutParams2);
                        return;
                    }
                }
                List list6 = this.this$0.absent;
                Intrinsics.checkNotNull(list6);
                if (!((Boolean) list6.get(position)).booleanValue()) {
                    List list7 = this.this$0.leaves;
                    Intrinsics.checkNotNull(list7);
                    if (!((Boolean) list7.get(position)).booleanValue()) {
                        List list8 = this.this$0.present;
                        Intrinsics.checkNotNull(list8);
                        if (!((Boolean) list8.get(position)).booleanValue()) {
                            List list9 = this.this$0.rejects;
                            Intrinsics.checkNotNull(list9);
                            if (((Boolean) list9.get(position)).booleanValue()) {
                                this.dayMarker.setBackgroundResource(R.drawable.reject_hostel);
                                ViewGroup.LayoutParams layoutParams3 = this.dayMarker.getLayoutParams();
                                Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                                marginLayoutParams3.width = this.this$0.getDp(10);
                                marginLayoutParams3.height = this.this$0.getDp(10);
                                marginLayoutParams3.setMargins(this.this$0.getDp(5), this.this$0.getDp(5), this.this$0.getDp(5), this.this$0.getDp(5));
                                this.dayMarker.setLayoutParams(marginLayoutParams3);
                                return;
                            }
                            ViewGroup.LayoutParams layoutParams4 = this.dayMarker.getLayoutParams();
                            Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                            marginLayoutParams4.width = this.this$0.getDp(10);
                            marginLayoutParams4.height = this.this$0.getDp(10);
                            marginLayoutParams4.setMargins(this.this$0.getDp(5), this.this$0.getDp(5), this.this$0.getDp(5), this.this$0.getDp(5));
                            this.dayMarker.setLayoutParams(marginLayoutParams4);
                            return;
                        }
                        this.dayMarker.setBackgroundResource(R.drawable.present_hostel);
                        ViewGroup.LayoutParams layoutParams5 = this.dayMarker.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams5;
                        marginLayoutParams5.width = this.this$0.getDp(10);
                        marginLayoutParams5.height = this.this$0.getDp(10);
                        marginLayoutParams5.setMargins(this.this$0.getDp(5), this.this$0.getDp(5), this.this$0.getDp(5), this.this$0.getDp(5));
                        this.dayMarker.setLayoutParams(marginLayoutParams5);
                        return;
                    }
                    this.dayMarker.setBackgroundResource(R.drawable.leaves_hostel);
                    ViewGroup.LayoutParams layoutParams6 = this.dayMarker.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams6, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) layoutParams6;
                    marginLayoutParams6.width = this.this$0.getDp(10);
                    marginLayoutParams6.height = this.this$0.getDp(10);
                    marginLayoutParams6.setMargins(this.this$0.getDp(5), this.this$0.getDp(5), this.this$0.getDp(5), this.this$0.getDp(5));
                    this.dayMarker.setLayoutParams(marginLayoutParams6);
                    return;
                }
                this.dayMarker.setBackgroundResource(R.drawable.absent_hostel);
                ViewGroup.LayoutParams layoutParams7 = this.dayMarker.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams7, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams7 = (ViewGroup.MarginLayoutParams) layoutParams7;
                marginLayoutParams7.width = this.this$0.getDp(10);
                marginLayoutParams7.height = this.this$0.getDp(10);
                marginLayoutParams7.setMargins(this.this$0.getDp(5), this.this$0.getDp(5), this.this$0.getDp(5), this.this$0.getDp(5));
                this.dayMarker.setLayoutParams(marginLayoutParams7);
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(List<String> list, List<Boolean> listP, List<Boolean> listA, List<Boolean> listNA, List<Boolean> noOfPeriods) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(listP, "listP");
        Intrinsics.checkNotNullParameter(listA, "listA");
        Intrinsics.checkNotNullParameter(listNA, "listNA");
        Intrinsics.checkNotNullParameter(noOfPeriods, "noOfPeriods");
        this.present = listP;
        this.absent = listA;
        this.leaves = listNA;
        this.daysOfMonth = list;
        this.noOfDays = list.size();
        this.rejects = noOfPeriods;
        notifyDataSetChanged();
    }

    public final int getDp(int i) {
        return (int) (i * Resources.getSystem().getDisplayMetrics().density);
    }
}