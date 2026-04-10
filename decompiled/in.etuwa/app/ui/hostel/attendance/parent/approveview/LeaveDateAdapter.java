package in.etuwa.app.ui.hostel.attendance.parent.approveview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.databinding.ItemLeaveDateBinding;
import in.etuwa.app.ui.hostel.attendance.parent.approveview.LeaveDateAdapter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ParentApproveAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class LeaveDateAdapter extends RecyclerView.Adapter<DateViewHolder> {
    private final Map<String, Boolean> checkedStates;
    private final List<LeaveDateItem> dates;
    private final Function0<Unit> onStateChanged;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    private static final SimpleDateFormat fullFormat = new SimpleDateFormat("EEEE, MMM dd, yyyy", Locale.getDefault());
    private static final SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.getDefault());
    private static final SimpleDateFormat monthFormat = new SimpleDateFormat("MMM", Locale.getDefault());

    public LeaveDateAdapter(List<LeaveDateItem> dates, Function0<Unit> onStateChanged) {
        Intrinsics.checkNotNullParameter(dates, "dates");
        Intrinsics.checkNotNullParameter(onStateChanged, "onStateChanged");
        this.dates = dates;
        this.onStateChanged = onStateChanged;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = dates.iterator();
        while (it.hasNext()) {
            linkedHashMap.put(((LeaveDateItem) it.next()).getId(), false);
        }
        this.checkedStates = linkedHashMap;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemLeaveDateBinding itemLeaveDateBindingInflate = ItemLeaveDateBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemLeaveDateBindingInflate, "inflate(\n            Lay…          false\n        )");
        return new DateViewHolder(this, itemLeaveDateBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DateViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.dates.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dates.size();
    }

    public final void selectAll(boolean checked) {
        for (LeaveDateItem leaveDateItem : this.dates) {
            this.checkedStates.put(leaveDateItem.getId(), Boolean.valueOf(checked));
        }
        notifyDataSetChanged();
        this.onStateChanged.invoke();
    }

    public final List<LeaveDateState> getDateStates() {
        List<LeaveDateItem> list = this.dates;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (LeaveDateItem leaveDateItem : list) {
            String id = leaveDateItem.getId();
            String date = leaveDateItem.getDate();
            Boolean bool = this.checkedStates.get(leaveDateItem.getId());
            arrayList.add(new LeaveDateState(id, date, bool != null ? bool.booleanValue() : false));
        }
        return arrayList;
    }

    /* JADX INFO: compiled from: ParentApproveAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/hostel/attendance/parent/approveview/LeaveDateAdapter$DateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lin/etuwa/app/databinding/ItemLeaveDateBinding;", "(Lin/etuwa/app/ui/hostel/attendance/parent/approveview/LeaveDateAdapter;Lin/etuwa/app/databinding/ItemLeaveDateBinding;)V", "bind", "", "item", "Lin/etuwa/app/ui/hostel/attendance/parent/approveview/LeaveDateItem;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class DateViewHolder extends RecyclerView.ViewHolder {
        private final ItemLeaveDateBinding binding;
        final /* synthetic */ LeaveDateAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DateViewHolder(LeaveDateAdapter leaveDateAdapter, ItemLeaveDateBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = leaveDateAdapter;
            this.binding = binding;
        }

        public final void bind(final LeaveDateItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.binding.tvDate.setText(LeaveDateAdapter.INSTANCE.formatDate(item.getDate()));
            this.binding.checkboxDate.setOnCheckedChangeListener(null);
            MaterialCheckBox materialCheckBox = this.binding.checkboxDate;
            Boolean bool = (Boolean) this.this$0.checkedStates.get(item.getId());
            materialCheckBox.setChecked(bool != null ? bool.booleanValue() : false);
            MaterialCheckBox materialCheckBox2 = this.binding.checkboxDate;
            final LeaveDateAdapter leaveDateAdapter = this.this$0;
            materialCheckBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.hostel.attendance.parent.approveview.LeaveDateAdapter$DateViewHolder$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    LeaveDateAdapter.DateViewHolder.bind$lambda$0(leaveDateAdapter, item, compoundButton, z);
                }
            });
            MaterialCardView materialCardView = this.binding.cardDateItem;
            final LeaveDateAdapter leaveDateAdapter2 = this.this$0;
            materialCardView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.parent.approveview.LeaveDateAdapter$DateViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LeaveDateAdapter.DateViewHolder.bind$lambda$1(this.f$0, leaveDateAdapter2, item, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(LeaveDateAdapter this$0, LeaveDateItem item, CompoundButton compoundButton, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            Intrinsics.checkNotNullParameter(compoundButton, "<anonymous parameter 0>");
            this$0.checkedStates.put(item.getId(), Boolean.valueOf(z));
            this$0.onStateChanged.invoke();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(DateViewHolder this$0, LeaveDateAdapter this$1, LeaveDateItem item, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.binding.checkboxDate.setChecked(!(((Boolean) this$1.checkedStates.get(item.getId())) != null ? r1.booleanValue() : false));
        }
    }

    /* JADX INFO: compiled from: ParentApproveAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lin/etuwa/app/ui/hostel/attendance/parent/approveview/LeaveDateAdapter$Companion;", "", "()V", "dayFormat", "Ljava/text/SimpleDateFormat;", "fullFormat", "inputFormat", "monthFormat", "formatDate", "", "date", "getDayNumber", "getMonthName", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String formatDate(String date) {
            Object objM1430constructorimpl;
            try {
                Result.Companion companion = Result.INSTANCE;
                Companion companion2 = this;
                SimpleDateFormat simpleDateFormat = LeaveDateAdapter.fullFormat;
                Date date2 = LeaveDateAdapter.inputFormat.parse(date);
                Intrinsics.checkNotNull(date2);
                objM1430constructorimpl = Result.m1430constructorimpl(simpleDateFormat.format(date2));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM1430constructorimpl = Result.m1430constructorimpl(ResultKt.createFailure(th));
            }
            Object obj = date;
            if (!Result.m1436isFailureimpl(objM1430constructorimpl)) {
                obj = objM1430constructorimpl;
            }
            return (String) obj;
        }

        private final String getDayNumber(String date) {
            Object objM1430constructorimpl;
            try {
                Result.Companion companion = Result.INSTANCE;
                Companion companion2 = this;
                SimpleDateFormat simpleDateFormat = LeaveDateAdapter.dayFormat;
                Date date2 = LeaveDateAdapter.inputFormat.parse(date);
                Intrinsics.checkNotNull(date2);
                objM1430constructorimpl = Result.m1430constructorimpl(simpleDateFormat.format(date2));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM1430constructorimpl = Result.m1430constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m1436isFailureimpl(objM1430constructorimpl)) {
                objM1430constructorimpl = "";
            }
            return (String) objM1430constructorimpl;
        }

        private final String getMonthName(String date) {
            Object objM1430constructorimpl;
            try {
                Result.Companion companion = Result.INSTANCE;
                Companion companion2 = this;
                SimpleDateFormat simpleDateFormat = LeaveDateAdapter.monthFormat;
                Date date2 = LeaveDateAdapter.inputFormat.parse(date);
                Intrinsics.checkNotNull(date2);
                String str = simpleDateFormat.format(date2);
                Intrinsics.checkNotNullExpressionValue(str, "monthFormat.format(inputFormat.parse(date)!!)");
                String upperCase = str.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                objM1430constructorimpl = Result.m1430constructorimpl(upperCase);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM1430constructorimpl = Result.m1430constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m1436isFailureimpl(objM1430constructorimpl)) {
                objM1430constructorimpl = "";
            }
            return (String) objM1430constructorimpl;
        }
    }
}