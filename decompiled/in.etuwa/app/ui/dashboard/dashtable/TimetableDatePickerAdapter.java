package in.etuwa.app.ui.dashboard.dashtable;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.helper.ValidChecker$$ExternalSyntheticApiModelOutline0;
import in.etuwa.app.ui.dashboard.dashtable.TimetableDatePickerAdapter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimetableDatePickerAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TimetableDatePickerAdapter extends RecyclerView.Adapter<DayViewHolder> {
    private Set<LocalDate> currentWeekDates;
    private final List<LocalDate> days;
    private final Function1<LocalDate, Unit> onDateSelected;
    private LocalDate selectedDate;

    /* JADX WARN: Multi-variable type inference failed */
    public TimetableDatePickerAdapter(Function1<? super LocalDate, Unit> onDateSelected) {
        Intrinsics.checkNotNullParameter(onDateSelected, "onDateSelected");
        this.onDateSelected = onDateSelected;
        this.days = new ArrayList();
        LocalDate localDateNow = LocalDate.now();
        Intrinsics.checkNotNullExpressionValue(localDateNow, "now()");
        this.selectedDate = localDateNow;
        this.currentWeekDates = SetsKt.emptySet();
    }

    public final void submitMonth(int year, int month, LocalDate selected, Set<LocalDate> weekDates) {
        Intrinsics.checkNotNullParameter(selected, "selected");
        Intrinsics.checkNotNullParameter(weekDates, "weekDates");
        this.selectedDate = selected;
        this.currentWeekDates = weekDates;
        this.days.clear();
        int i = 1;
        LocalDate localDateOf = LocalDate.of(year, month, 1);
        int iLengthOfMonth = localDateOf.lengthOfMonth();
        int value = localDateOf.getDayOfWeek().getValue() - 1;
        if (value == 7) {
            value = 0;
        }
        for (int i2 = 0; i2 < value; i2++) {
            this.days.add(null);
        }
        if (1 <= iLengthOfMonth) {
            while (true) {
                this.days.add(LocalDate.of(year, month, i));
                if (i == iLengthOfMonth) {
                    break;
                } else {
                    i++;
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_date_picker_day, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new DayViewHolder(this, view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.days.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DayViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(ValidChecker$$ExternalSyntheticApiModelOutline0.m((Object) this.days.get(position)));
    }

    /* JADX INFO: compiled from: TimetableDatePickerAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lin/etuwa/app/ui/dashboard/dashtable/TimetableDatePickerAdapter$DayViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/dashboard/dashtable/TimetableDatePickerAdapter;Landroid/view/View;)V", "dot", "tv", "Landroid/widget/TextView;", "bind", "", "date", "Ljava/time/LocalDate;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class DayViewHolder extends RecyclerView.ViewHolder {
        private final View dot;
        final /* synthetic */ TimetableDatePickerAdapter this$0;
        private final TextView tv;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DayViewHolder(TimetableDatePickerAdapter timetableDatePickerAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = timetableDatePickerAdapter;
            View viewFindViewById = itemView.findViewById(R.id.day_tv);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "itemView.findViewById(R.id.day_tv)");
            this.tv = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.week_dot);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "itemView.findViewById(R.id.week_dot)");
            this.dot = viewFindViewById2;
        }

        public final void bind(final LocalDate date) {
            int color;
            int i = 4;
            if (date == null) {
                this.tv.setText("");
                this.tv.setBackground(null);
                this.dot.setVisibility(4);
                this.itemView.setOnClickListener(null);
                return;
            }
            this.tv.setText(String.valueOf(date.getDayOfMonth()));
            boolean zAreEqual = Intrinsics.areEqual(date, this.this$0.selectedDate);
            boolean zAreEqual2 = Intrinsics.areEqual(date, LocalDate.now());
            boolean zContains = this.this$0.currentWeekDates.contains(date);
            boolean z = date.getDayOfWeek().getValue() == 7;
            boolean z2 = date.getDayOfWeek().getValue() == 6;
            if (zAreEqual) {
                this.tv.setBackgroundResource(R.drawable.shape_round_selected);
                this.tv.setTextColor(-1);
                this.tv.setTypeface(Typeface.DEFAULT_BOLD);
            } else if (zAreEqual2) {
                this.tv.setBackgroundResource(R.drawable.shape_today_ring);
                this.tv.setTextColor(Color.parseColor("#5F9EA0"));
                this.tv.setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                this.tv.setBackground(null);
                this.tv.setTypeface(Typeface.DEFAULT);
                TextView textView = this.tv;
                if (z) {
                    color = Color.parseColor("#C62828");
                } else if (z2) {
                    color = Color.parseColor("#5F9EA0");
                } else {
                    color = Color.parseColor("#333333");
                }
                textView.setTextColor(color);
            }
            View view = this.dot;
            if (zContains && !zAreEqual) {
                i = 0;
            }
            view.setVisibility(i);
            View view2 = this.itemView;
            final TimetableDatePickerAdapter timetableDatePickerAdapter = this.this$0;
            view2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.dashboard.dashtable.TimetableDatePickerAdapter$DayViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    TimetableDatePickerAdapter.DayViewHolder.bind$lambda$0(timetableDatePickerAdapter, date, view3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(TimetableDatePickerAdapter this$0, LocalDate localDate, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.onDateSelected.invoke(localDate);
        }
    }
}