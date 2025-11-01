package in.etuwa.app.ui.attendance.calendarview;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewAdapter;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttendanceCalendarViewAdapter.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002%&B\u0005¢\u0006\u0002\u0010\u0003JZ\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0005J\b\u0010\u0019\u001a\u00020\rH\u0016J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\rH\u0016J\u0010\u0010\"\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010$R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lin/etuwa/app/ui/attendance/calendarview/AttendanceCalendarViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "absent", "", "", "daysOfMonth", "holiday", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/attendance/calendarview/AttendanceCalendarViewAdapter$DayClickListener;", "noOfDays", "", "notavailable", "periods", "present", "addItems", "", "list", "listP", "listA", "listNA", "noOfPeriods", "holidayList", "getItemCount", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCalendarCallBack", "context", "Lin/etuwa/app/ui/attendance/calendarview/AttendanceCalendarViewFragment;", "DayClickListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AttendanceCalendarViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<String> absent;
    private List<String> daysOfMonth;
    private List<Boolean> holiday;
    private DayClickListener listener;
    private int noOfDays;
    private List<String> notavailable;
    private List<Integer> periods;
    private List<String> present;

    /* compiled from: AttendanceCalendarViewAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lin/etuwa/app/ui/attendance/calendarview/AttendanceCalendarViewAdapter$DayClickListener;", "", "onDateClicked", "", "day", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface DayClickListener {
        void onDateClicked(String day);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(inflate);
        }
        if (viewType == 1) {
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_calendar_days, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …ndar_days, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
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

    /* compiled from: AttendanceCalendarViewAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/ui/attendance/calendarview/AttendanceCalendarViewAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/attendance/calendarview/AttendanceCalendarViewAdapter;Landroid/view/View;)V", "dayMarker", "Landroid/widget/ImageView;", "getDayMarker", "()Landroid/widget/ImageView;", "tvDay", "Landroid/widget/TextView;", "getTvDay", "()Landroid/widget/TextView;", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final ImageView dayMarker;
        final /* synthetic */ AttendanceCalendarViewAdapter this$0;
        private final TextView tvDay;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(AttendanceCalendarViewAdapter attendanceCalendarViewAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = attendanceCalendarViewAdapter;
            View findViewById = itemView.findViewById(R.id.tvDay);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tvDay)");
            this.tvDay = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.dayMarker);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.dayMarker)");
            this.dayMarker = (ImageView) findViewById2;
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
                final String str = (String) list.get(position);
                if (!Intrinsics.areEqual(str, "")) {
                    this.dayMarker.setVisibility(0);
                } else {
                    this.dayMarker.setVisibility(8);
                }
                TextView textView = this.tvDay;
                final AttendanceCalendarViewAdapter attendanceCalendarViewAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AttendanceCalendarViewAdapter.ViewHolder.onBind$lambda$0(str, attendanceCalendarViewAdapter, view);
                    }
                });
                ImageView imageView = this.dayMarker;
                final AttendanceCalendarViewAdapter attendanceCalendarViewAdapter2 = this.this$0;
                imageView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.attendance.calendarview.AttendanceCalendarViewAdapter$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AttendanceCalendarViewAdapter.ViewHolder.onBind$lambda$1(str, attendanceCalendarViewAdapter2, view);
                    }
                });
                this.tvDay.setText(str);
                if (Intrinsics.areEqual(str, "")) {
                    return;
                }
                List list2 = this.this$0.holiday;
                Intrinsics.checkNotNull(list2);
                if (!((Boolean) list2.get(position)).booleanValue()) {
                    List list3 = this.this$0.absent;
                    Intrinsics.checkNotNull(list3);
                    if (Intrinsics.areEqual(list3.get(position), "7")) {
                        List list4 = this.this$0.periods;
                        Intrinsics.checkNotNull(list4);
                        if (((Number) list4.get(position)).intValue() == 7) {
                            this.tvDay.setTextColor(Color.parseColor("#FF0000"));
                            return;
                        }
                    }
                    List list5 = this.this$0.absent;
                    Intrinsics.checkNotNull(list5);
                    if (Intrinsics.areEqual(list5.get(position), "8")) {
                        List list6 = this.this$0.periods;
                        Intrinsics.checkNotNull(list6);
                        if (((Number) list6.get(position)).intValue() == 8) {
                            this.tvDay.setTextColor(Color.parseColor("#FF0000"));
                            return;
                        }
                    }
                    List list7 = this.this$0.absent;
                    Intrinsics.checkNotNull(list7);
                    if (Intrinsics.areEqual(list7.get(position), "6")) {
                        List list8 = this.this$0.periods;
                        Intrinsics.checkNotNull(list8);
                        if (((Number) list8.get(position)).intValue() == 6) {
                            this.tvDay.setTextColor(Color.parseColor("#FF0000"));
                            return;
                        }
                    }
                    List list9 = this.this$0.present;
                    Intrinsics.checkNotNull(list9);
                    if (Intrinsics.areEqual(list9.get(position), "6")) {
                        List list10 = this.this$0.periods;
                        Intrinsics.checkNotNull(list10);
                        if (((Number) list10.get(position)).intValue() == 6) {
                            this.tvDay.setTextColor(Color.parseColor("#008000"));
                            return;
                        }
                    }
                    List list11 = this.this$0.present;
                    Intrinsics.checkNotNull(list11);
                    if (Intrinsics.areEqual(list11.get(position), "7")) {
                        List list12 = this.this$0.periods;
                        Intrinsics.checkNotNull(list12);
                        if (((Number) list12.get(position)).intValue() == 7) {
                            this.tvDay.setTextColor(Color.parseColor("#008000"));
                            return;
                        }
                    }
                    List list13 = this.this$0.present;
                    Intrinsics.checkNotNull(list13);
                    if (Intrinsics.areEqual(list13.get(position), "8")) {
                        List list14 = this.this$0.periods;
                        Intrinsics.checkNotNull(list14);
                        if (((Number) list14.get(position)).intValue() == 8) {
                            this.tvDay.setTextColor(Color.parseColor("#008000"));
                            return;
                        }
                    }
                    List list15 = this.this$0.present;
                    Intrinsics.checkNotNull(list15);
                    if (Intrinsics.areEqual(list15.get(position), "0")) {
                        List list16 = this.this$0.absent;
                        Intrinsics.checkNotNull(list16);
                        if (Intrinsics.areEqual(list16.get(position), "1")) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenzeroredone);
                            return;
                        }
                    }
                    List list17 = this.this$0.present;
                    Intrinsics.checkNotNull(list17);
                    if (Intrinsics.areEqual(list17.get(position), "0")) {
                        List list18 = this.this$0.absent;
                        Intrinsics.checkNotNull(list18);
                        if (Intrinsics.areEqual(list18.get(position), ExifInterface.GPS_MEASUREMENT_2D)) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenzeroredtwo);
                            return;
                        }
                    }
                    List list19 = this.this$0.present;
                    Intrinsics.checkNotNull(list19);
                    if (Intrinsics.areEqual(list19.get(position), "0")) {
                        List list20 = this.this$0.absent;
                        Intrinsics.checkNotNull(list20);
                        if (Intrinsics.areEqual(list20.get(position), ExifInterface.GPS_MEASUREMENT_3D)) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenzeroredthree);
                            return;
                        }
                    }
                    List list21 = this.this$0.present;
                    Intrinsics.checkNotNull(list21);
                    if (Intrinsics.areEqual(list21.get(position), "0")) {
                        List list22 = this.this$0.absent;
                        Intrinsics.checkNotNull(list22);
                        if (Intrinsics.areEqual(list22.get(position), "4")) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenzeroredfour);
                            return;
                        }
                    }
                    List list23 = this.this$0.present;
                    Intrinsics.checkNotNull(list23);
                    if (Intrinsics.areEqual(list23.get(position), "0")) {
                        List list24 = this.this$0.absent;
                        Intrinsics.checkNotNull(list24);
                        if (Intrinsics.areEqual(list24.get(position), "5")) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenzeroredfive);
                            return;
                        }
                    }
                    List list25 = this.this$0.present;
                    Intrinsics.checkNotNull(list25);
                    if (Intrinsics.areEqual(list25.get(position), "0")) {
                        List list26 = this.this$0.absent;
                        Intrinsics.checkNotNull(list26);
                        if (Intrinsics.areEqual(list26.get(position), "6")) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenzeroredsix);
                            return;
                        }
                    }
                    List list27 = this.this$0.present;
                    Intrinsics.checkNotNull(list27);
                    if (Intrinsics.areEqual(list27.get(position), "0")) {
                        List list28 = this.this$0.absent;
                        Intrinsics.checkNotNull(list28);
                        if (Intrinsics.areEqual(list28.get(position), "7")) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenzeroredseven);
                            return;
                        }
                    }
                    List list29 = this.this$0.present;
                    Intrinsics.checkNotNull(list29);
                    if (Intrinsics.areEqual(list29.get(position), "0")) {
                        List list30 = this.this$0.absent;
                        Intrinsics.checkNotNull(list30);
                        if (Intrinsics.areEqual(list30.get(position), "8")) {
                            this.dayMarker.setBackgroundResource(R.drawable.ic_present);
                            return;
                        }
                    }
                    List list31 = this.this$0.present;
                    Intrinsics.checkNotNull(list31);
                    if (Intrinsics.areEqual(list31.get(position), "1")) {
                        List list32 = this.this$0.absent;
                        Intrinsics.checkNotNull(list32);
                        if (Intrinsics.areEqual(list32.get(position), "1")) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenoneredone);
                            return;
                        }
                    }
                    List list33 = this.this$0.present;
                    Intrinsics.checkNotNull(list33);
                    if (Intrinsics.areEqual(list33.get(position), "1")) {
                        List list34 = this.this$0.absent;
                        Intrinsics.checkNotNull(list34);
                        if (Intrinsics.areEqual(list34.get(position), ExifInterface.GPS_MEASUREMENT_2D)) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenoneredtwo);
                            return;
                        }
                    }
                    List list35 = this.this$0.present;
                    Intrinsics.checkNotNull(list35);
                    if (Intrinsics.areEqual(list35.get(position), "1")) {
                        List list36 = this.this$0.absent;
                        Intrinsics.checkNotNull(list36);
                        if (Intrinsics.areEqual(list36.get(position), ExifInterface.GPS_MEASUREMENT_3D)) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenoneredthree);
                            return;
                        }
                    }
                    List list37 = this.this$0.present;
                    Intrinsics.checkNotNull(list37);
                    if (Intrinsics.areEqual(list37.get(position), "1")) {
                        List list38 = this.this$0.absent;
                        Intrinsics.checkNotNull(list38);
                        if (Intrinsics.areEqual(list38.get(position), "4")) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenoneredfour);
                            return;
                        }
                    }
                    List list39 = this.this$0.present;
                    Intrinsics.checkNotNull(list39);
                    if (Intrinsics.areEqual(list39.get(position), "1")) {
                        List list40 = this.this$0.absent;
                        Intrinsics.checkNotNull(list40);
                        if (Intrinsics.areEqual(list40.get(position), "5")) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenoneredfive);
                            return;
                        }
                    }
                    List list41 = this.this$0.present;
                    Intrinsics.checkNotNull(list41);
                    if (Intrinsics.areEqual(list41.get(position), "1")) {
                        List list42 = this.this$0.absent;
                        Intrinsics.checkNotNull(list42);
                        if (Intrinsics.areEqual(list42.get(position), "6")) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenoneredsix);
                            return;
                        }
                    }
                    List list43 = this.this$0.present;
                    Intrinsics.checkNotNull(list43);
                    if (Intrinsics.areEqual(list43.get(position), "1")) {
                        List list44 = this.this$0.absent;
                        Intrinsics.checkNotNull(list44);
                        if (Intrinsics.areEqual(list44.get(position), "7")) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenoneredseven);
                            return;
                        }
                    }
                    List list45 = this.this$0.present;
                    Intrinsics.checkNotNull(list45);
                    if (Intrinsics.areEqual(list45.get(position), ExifInterface.GPS_MEASUREMENT_2D)) {
                        List list46 = this.this$0.absent;
                        Intrinsics.checkNotNull(list46);
                        if (Intrinsics.areEqual(list46.get(position), "1")) {
                            this.dayMarker.setBackgroundResource(R.drawable.greentworedone);
                            return;
                        }
                    }
                    List list47 = this.this$0.present;
                    Intrinsics.checkNotNull(list47);
                    if (Intrinsics.areEqual(list47.get(position), ExifInterface.GPS_MEASUREMENT_2D)) {
                        List list48 = this.this$0.absent;
                        Intrinsics.checkNotNull(list48);
                        if (Intrinsics.areEqual(list48.get(position), ExifInterface.GPS_MEASUREMENT_2D)) {
                            this.dayMarker.setBackgroundResource(R.drawable.greentworedtwo);
                            return;
                        }
                    }
                    List list49 = this.this$0.present;
                    Intrinsics.checkNotNull(list49);
                    if (Intrinsics.areEqual(list49.get(position), ExifInterface.GPS_MEASUREMENT_2D)) {
                        List list50 = this.this$0.absent;
                        Intrinsics.checkNotNull(list50);
                        if (Intrinsics.areEqual(list50.get(position), ExifInterface.GPS_MEASUREMENT_3D)) {
                            this.dayMarker.setBackgroundResource(R.drawable.greentworedthree);
                            return;
                        }
                    }
                    List list51 = this.this$0.present;
                    Intrinsics.checkNotNull(list51);
                    if (Intrinsics.areEqual(list51.get(position), ExifInterface.GPS_MEASUREMENT_2D)) {
                        List list52 = this.this$0.absent;
                        Intrinsics.checkNotNull(list52);
                        if (Intrinsics.areEqual(list52.get(position), "4")) {
                            this.dayMarker.setBackgroundResource(R.drawable.greentworedfour);
                            return;
                        }
                    }
                    List list53 = this.this$0.present;
                    Intrinsics.checkNotNull(list53);
                    if (Intrinsics.areEqual(list53.get(position), ExifInterface.GPS_MEASUREMENT_2D)) {
                        List list54 = this.this$0.absent;
                        Intrinsics.checkNotNull(list54);
                        if (Intrinsics.areEqual(list54.get(position), "5")) {
                            this.dayMarker.setBackgroundResource(R.drawable.greentworedfive);
                            return;
                        }
                    }
                    List list55 = this.this$0.present;
                    Intrinsics.checkNotNull(list55);
                    if (Intrinsics.areEqual(list55.get(position), ExifInterface.GPS_MEASUREMENT_2D)) {
                        List list56 = this.this$0.absent;
                        Intrinsics.checkNotNull(list56);
                        if (Intrinsics.areEqual(list56.get(position), "6")) {
                            this.dayMarker.setBackgroundResource(R.drawable.greentworedsix);
                            return;
                        }
                    }
                    List list57 = this.this$0.present;
                    Intrinsics.checkNotNull(list57);
                    if (Intrinsics.areEqual(list57.get(position), ExifInterface.GPS_MEASUREMENT_3D)) {
                        List list58 = this.this$0.absent;
                        Intrinsics.checkNotNull(list58);
                        if (Intrinsics.areEqual(list58.get(position), "1")) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenthreeredone);
                            return;
                        }
                    }
                    List list59 = this.this$0.present;
                    Intrinsics.checkNotNull(list59);
                    if (Intrinsics.areEqual(list59.get(position), ExifInterface.GPS_MEASUREMENT_3D)) {
                        List list60 = this.this$0.absent;
                        Intrinsics.checkNotNull(list60);
                        if (Intrinsics.areEqual(list60.get(position), ExifInterface.GPS_MEASUREMENT_2D)) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenthreeredtwo);
                            return;
                        }
                    }
                    List list61 = this.this$0.present;
                    Intrinsics.checkNotNull(list61);
                    if (Intrinsics.areEqual(list61.get(position), ExifInterface.GPS_MEASUREMENT_3D)) {
                        List list62 = this.this$0.absent;
                        Intrinsics.checkNotNull(list62);
                        if (Intrinsics.areEqual(list62.get(position), ExifInterface.GPS_MEASUREMENT_3D)) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenthreeredthree);
                            return;
                        }
                    }
                    List list63 = this.this$0.present;
                    Intrinsics.checkNotNull(list63);
                    if (Intrinsics.areEqual(list63.get(position), ExifInterface.GPS_MEASUREMENT_3D)) {
                        List list64 = this.this$0.absent;
                        Intrinsics.checkNotNull(list64);
                        if (Intrinsics.areEqual(list64.get(position), "4")) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenthreeredfour);
                            return;
                        }
                    }
                    List list65 = this.this$0.present;
                    Intrinsics.checkNotNull(list65);
                    if (Intrinsics.areEqual(list65.get(position), ExifInterface.GPS_MEASUREMENT_3D)) {
                        List list66 = this.this$0.absent;
                        Intrinsics.checkNotNull(list66);
                        if (Intrinsics.areEqual(list66.get(position), "5")) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenthreeredfive);
                            return;
                        }
                    }
                    List list67 = this.this$0.present;
                    Intrinsics.checkNotNull(list67);
                    if (Intrinsics.areEqual(list67.get(position), "4")) {
                        List list68 = this.this$0.absent;
                        Intrinsics.checkNotNull(list68);
                        if (Intrinsics.areEqual(list68.get(position), "1")) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenfourredone);
                            return;
                        }
                    }
                    List list69 = this.this$0.present;
                    Intrinsics.checkNotNull(list69);
                    if (Intrinsics.areEqual(list69.get(position), "4")) {
                        List list70 = this.this$0.absent;
                        Intrinsics.checkNotNull(list70);
                        if (Intrinsics.areEqual(list70.get(position), ExifInterface.GPS_MEASUREMENT_2D)) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenfourredtwo);
                            return;
                        }
                    }
                    List list71 = this.this$0.present;
                    Intrinsics.checkNotNull(list71);
                    if (Intrinsics.areEqual(list71.get(position), "4")) {
                        List list72 = this.this$0.absent;
                        Intrinsics.checkNotNull(list72);
                        if (Intrinsics.areEqual(list72.get(position), ExifInterface.GPS_MEASUREMENT_3D)) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenfourredthree);
                            return;
                        }
                    }
                    List list73 = this.this$0.present;
                    Intrinsics.checkNotNull(list73);
                    if (Intrinsics.areEqual(list73.get(position), "4")) {
                        List list74 = this.this$0.absent;
                        Intrinsics.checkNotNull(list74);
                        if (Intrinsics.areEqual(list74.get(position), "4")) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenfourredfour);
                            return;
                        }
                    }
                    List list75 = this.this$0.present;
                    Intrinsics.checkNotNull(list75);
                    if (Intrinsics.areEqual(list75.get(position), "5")) {
                        List list76 = this.this$0.absent;
                        Intrinsics.checkNotNull(list76);
                        if (Intrinsics.areEqual(list76.get(position), "1")) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenfiveredone);
                            return;
                        }
                    }
                    List list77 = this.this$0.present;
                    Intrinsics.checkNotNull(list77);
                    if (Intrinsics.areEqual(list77.get(position), "5")) {
                        List list78 = this.this$0.absent;
                        Intrinsics.checkNotNull(list78);
                        if (Intrinsics.areEqual(list78.get(position), ExifInterface.GPS_MEASUREMENT_2D)) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenfiveredtwo);
                            return;
                        }
                    }
                    List list79 = this.this$0.present;
                    Intrinsics.checkNotNull(list79);
                    if (Intrinsics.areEqual(list79.get(position), "5")) {
                        List list80 = this.this$0.absent;
                        Intrinsics.checkNotNull(list80);
                        if (Intrinsics.areEqual(list80.get(position), ExifInterface.GPS_MEASUREMENT_3D)) {
                            this.dayMarker.setBackgroundResource(R.drawable.greenfiveredthree);
                            return;
                        }
                    }
                    List list81 = this.this$0.present;
                    Intrinsics.checkNotNull(list81);
                    if (Intrinsics.areEqual(list81.get(position), "6")) {
                        List list82 = this.this$0.absent;
                        Intrinsics.checkNotNull(list82);
                        if (Intrinsics.areEqual(list82.get(position), "1")) {
                            this.dayMarker.setBackgroundResource(R.drawable.greensixredone);
                            return;
                        }
                    }
                    List list83 = this.this$0.present;
                    Intrinsics.checkNotNull(list83);
                    if (Intrinsics.areEqual(list83.get(position), "6")) {
                        List list84 = this.this$0.absent;
                        Intrinsics.checkNotNull(list84);
                        if (Intrinsics.areEqual(list84.get(position), ExifInterface.GPS_MEASUREMENT_2D)) {
                            this.dayMarker.setBackgroundResource(R.drawable.greensixredtwo);
                            return;
                        }
                    }
                    List list85 = this.this$0.present;
                    Intrinsics.checkNotNull(list85);
                    if (Intrinsics.areEqual(list85.get(position), "7")) {
                        List list86 = this.this$0.absent;
                        Intrinsics.checkNotNull(list86);
                        if (Intrinsics.areEqual(list86.get(position), "1")) {
                            this.dayMarker.setBackgroundResource(R.drawable.greensevenredone);
                            return;
                        }
                    }
                    List list87 = this.this$0.present;
                    Intrinsics.checkNotNull(list87);
                    if (!Intrinsics.areEqual(list87.get(position), "1")) {
                        List list88 = this.this$0.present;
                        Intrinsics.checkNotNull(list88);
                        if (!Intrinsics.areEqual(list88.get(position), ExifInterface.GPS_MEASUREMENT_2D)) {
                            List list89 = this.this$0.present;
                            Intrinsics.checkNotNull(list89);
                            if (!Intrinsics.areEqual(list89.get(position), ExifInterface.GPS_MEASUREMENT_3D)) {
                                List list90 = this.this$0.present;
                                Intrinsics.checkNotNull(list90);
                                if (!Intrinsics.areEqual(list90.get(position), "4")) {
                                    List list91 = this.this$0.present;
                                    Intrinsics.checkNotNull(list91);
                                    if (!Intrinsics.areEqual(list91.get(position), "5")) {
                                        List list92 = this.this$0.present;
                                        Intrinsics.checkNotNull(list92);
                                        if (!Intrinsics.areEqual(list92.get(position), "6")) {
                                            List list93 = this.this$0.notavailable;
                                            Intrinsics.checkNotNull(list93);
                                            Object obj = list93.get(position);
                                            List list94 = this.this$0.periods;
                                            Intrinsics.checkNotNull(list94);
                                            if (Intrinsics.areEqual(obj, String.valueOf(((Number) list94.get(position)).intValue()))) {
                                                this.tvDay.setTextColor(Color.parseColor("#0096FF"));
                                                return;
                                            }
                                            return;
                                        }
                                        this.dayMarker.setBackgroundResource(R.drawable.ic_six);
                                        return;
                                    }
                                    this.dayMarker.setBackgroundResource(R.drawable.ic_five);
                                    return;
                                }
                                this.dayMarker.setBackgroundResource(R.drawable.ic_four);
                                return;
                            }
                            this.dayMarker.setBackgroundResource(R.drawable.ic_three);
                            return;
                        }
                        this.dayMarker.setBackgroundResource(R.drawable.ic_two);
                        return;
                    }
                    this.dayMarker.setBackgroundResource(R.drawable.ic_one);
                    return;
                }
                this.tvDay.setTextColor(Color.parseColor("#FFBF00"));
                this.tvDay.setTypeface(null, 1);
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(String daysOfMonth, AttendanceCalendarViewAdapter this$0, View view) {
            DayClickListener dayClickListener;
            Intrinsics.checkNotNullParameter(daysOfMonth, "$daysOfMonth");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (Intrinsics.areEqual(daysOfMonth, "") || (dayClickListener = this$0.listener) == null) {
                return;
            }
            dayClickListener.onDateClicked(daysOfMonth);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(String daysOfMonth, AttendanceCalendarViewAdapter this$0, View view) {
            DayClickListener dayClickListener;
            Intrinsics.checkNotNullParameter(daysOfMonth, "$daysOfMonth");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (Intrinsics.areEqual(daysOfMonth, "") || (dayClickListener = this$0.listener) == null) {
                return;
            }
            dayClickListener.onDateClicked(daysOfMonth);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(List<String> list, List<String> listP, List<String> listA, List<String> listNA, List<Integer> noOfPeriods, List<Boolean> holidayList) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(listP, "listP");
        Intrinsics.checkNotNullParameter(listA, "listA");
        Intrinsics.checkNotNullParameter(listNA, "listNA");
        Intrinsics.checkNotNullParameter(noOfPeriods, "noOfPeriods");
        Intrinsics.checkNotNullParameter(holidayList, "holidayList");
        this.present = listP;
        this.absent = listA;
        this.notavailable = listNA;
        this.daysOfMonth = list;
        this.noOfDays = list.size();
        this.periods = noOfPeriods;
        this.holiday = holidayList;
        notifyDataSetChanged();
    }

    public final void setCalendarCallBack(AttendanceCalendarViewFragment context) {
        this.listener = context;
    }
}