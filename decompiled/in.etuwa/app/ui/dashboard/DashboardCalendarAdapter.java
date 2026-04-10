package in.etuwa.app.ui.dashboard;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.dashboard.DashboardCalendarAdapter;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DashboardCalendarAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DashboardCalendarAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private LocalDate currentMonthDate;
    private List<String> daysOfMonth = CollectionsKt.emptyList();
    private Map<LocalDate, ? extends List<CalendarEvent>> eventMap = MapsKt.emptyMap();
    private DayClickListener listener;
    private int noOfDays;
    private LocalDate selectedDate;
    private final LocalDate today;

    /* JADX INFO: compiled from: DashboardCalendarAdapter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/dashboard/DashboardCalendarAdapter$DayClickListener;", "", "onDateClicked", "", "date", "Ljava/time/LocalDate;", "events", "", "Lin/etuwa/app/ui/dashboard/CalendarEvent;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface DayClickListener {
        void onDateClicked(LocalDate date, List<CalendarEvent> events);
    }

    /* JADX INFO: compiled from: DashboardCalendarAdapter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CalendarEventType.values().length];
            try {
                iArr[CalendarEventType.ASSIGNMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CalendarEventType.HOLIDAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CalendarEventType.EXAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CalendarEventType.BIRTHDAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DashboardCalendarAdapter() {
        LocalDate localDateNow = LocalDate.now();
        Intrinsics.checkNotNullExpressionValue(localDateNow, "now()");
        this.currentMonthDate = localDateNow;
        this.today = LocalDate.now();
    }

    /* JADX INFO: compiled from: DashboardCalendarAdapter.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lin/etuwa/app/ui/dashboard/DashboardCalendarAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/dashboard/DashboardCalendarAdapter;Landroid/view/View;)V", "dayLyt", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "markerContainer", "tvDay", "Landroid/widget/TextView;", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final LinearLayout dayLyt;
        private final LinearLayout markerContainer;
        final /* synthetic */ DashboardCalendarAdapter this$0;
        private final TextView tvDay;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(DashboardCalendarAdapter dashboardCalendarAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = dashboardCalendarAdapter;
            this.tvDay = (TextView) itemView.findViewById(R.id.tvDay);
            this.markerContainer = (LinearLayout) itemView.findViewById(R.id.markerContainer);
            this.dayLyt = (LinearLayout) itemView.findViewById(R.id.days_lyt);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            String str = (String) this.this$0.daysOfMonth.get(position);
            this.markerContainer.removeAllViews();
            String str2 = str;
            if (str2.length() == 0) {
                this.dayLyt.setVisibility(4);
                return;
            }
            this.dayLyt.setVisibility(0);
            this.tvDay.setText(str2);
            final LocalDate localDateOf = LocalDate.of(this.this$0.currentMonthDate.getYear(), this.this$0.currentMonthDate.getMonth(), Integer.parseInt(str));
            if (Intrinsics.areEqual(this.this$0.today, localDateOf)) {
                this.tvDay.setBackgroundResource(R.drawable.bg_today_circle);
            } else {
                this.tvDay.setBackground(null);
            }
            List<CalendarEvent> list = (List) this.this$0.eventMap.get(localDateOf);
            if (list != null) {
                DashboardCalendarAdapter dashboardCalendarAdapter = this.this$0;
                for (CalendarEvent calendarEvent : list) {
                    LinearLayout linearLayout = this.markerContainer;
                    Context context = this.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                    linearLayout.addView(dashboardCalendarAdapter.createMarker(context, dashboardCalendarAdapter.getColor(calendarEvent.getType())));
                }
            }
            if (Intrinsics.areEqual(this.this$0.selectedDate, localDateOf)) {
                this.tvDay.setBackgroundResource(R.drawable.bg_selected_day);
            }
            LinearLayout linearLayout2 = this.dayLyt;
            final DashboardCalendarAdapter dashboardCalendarAdapter2 = this.this$0;
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.DashboardCalendarAdapter$ViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DashboardCalendarAdapter.ViewHolder.onBind$lambda$1(dashboardCalendarAdapter2, localDateOf, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(DashboardCalendarAdapter this$0, LocalDate fullDate, View view) {
            DayClickListener dayClickListener;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.selectedDate = fullDate;
            this$0.notifyDataSetChanged();
            List<CalendarEvent> listEmptyList = (List) this$0.eventMap.get(fullDate);
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            if (!(!listEmptyList.isEmpty()) || (dayClickListener = this$0.listener) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(fullDate, "fullDate");
            dayClickListener.onDateClicked(fullDate, listEmptyList);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_dashboard_cal_days, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context)\n   …lse\n                    )");
            return new ViewHolder(this, viewInflate);
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …lse\n                    )");
        return new EmptyViewHolder(viewInflate2);
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

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(List<String> days, Map<LocalDate, ? extends List<CalendarEvent>> events, LocalDate monthDate) {
        Intrinsics.checkNotNullParameter(days, "days");
        Intrinsics.checkNotNullParameter(events, "events");
        Intrinsics.checkNotNullParameter(monthDate, "monthDate");
        this.daysOfMonth = days;
        this.eventMap = events;
        this.currentMonthDate = monthDate;
        this.noOfDays = days.size();
        notifyDataSetChanged();
    }

    public final void setCalendarCallBack(DayClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View createMarker(Context context, int color) {
        View view = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(8, 8);
        layoutParams.setMarginEnd(3);
        view.setLayoutParams(layoutParams);
        view.setBackgroundResource(R.drawable.dot_modern);
        view.getBackground().setTint(color);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getColor(CalendarEventType type) {
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            return Color.parseColor("#2962FF");
        }
        if (i == 2) {
            return Color.parseColor("#2E7D32");
        }
        if (i == 3) {
            return Color.parseColor("#C62828");
        }
        if (i == 4) {
            return Color.parseColor("#AD1457");
        }
        throw new NoWhenBranchMatchedException();
    }
}