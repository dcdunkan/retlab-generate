package in.etuwa.app.ui.semregistration.mace;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.semregistration.AcademicYear;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AcademicYearSpinnerAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class AcademicYearSpinnerAdapter extends BaseAdapter {
    private AppCompatActivity activity;
    private ArrayList<AcademicYear> items;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public AcademicYearSpinnerAdapter(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.items = new ArrayList<>();
    }

    /* JADX INFO: compiled from: AcademicYearSpinnerAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/ui/semregistration/mace/AcademicYearSpinnerAdapter$ViewHolder;", "", CommonCssConstants.ROW, "Landroid/view/View;", "(Landroid/view/View;)V", "semName", "Landroid/widget/TextView;", "getSemName", "()Landroid/widget/TextView;", "setSemName", "(Landroid/widget/TextView;)V", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class ViewHolder {
        private TextView semName;

        public ViewHolder(View view) {
            this.semName = view != null ? (TextView) view.findViewById(R.id.fill_name) : null;
        }

        public final TextView getSemName() {
            return this.semName;
        }

        public final void setSemName(TextView textView) {
            this.semName = textView;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            Object systemService = this.activity.getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            convertView = ((LayoutInflater) systemService).inflate(R.layout.layout_fill_list, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(convertView, "inflater.inflate(R.layout.layout_fill_list, null)");
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            Object tag = convertView.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type in.etuwa.app.ui.semregistration.mace.AcademicYearSpinnerAdapter.ViewHolder");
            viewHolder = (ViewHolder) tag;
        }
        if (position == 0) {
            TextView semName = viewHolder.getSemName();
            if (semName != null) {
                semName.setText("Select");
            }
        } else {
            AcademicYear academicYear = this.items.get(position - 1);
            Intrinsics.checkNotNullExpressionValue(academicYear, "items[position-1]");
            AcademicYear academicYear2 = academicYear;
            TextView semName2 = viewHolder.getSemName();
            if (semName2 != null) {
                semName2.setText(academicYear2.getName());
            }
        }
        return convertView;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        AcademicYear academicYear = position == 0 ? null : this.items.get(position - 1);
        Intrinsics.checkNotNull(academicYear);
        return academicYear;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.items.size() + 1;
    }

    public final void addItems(ArrayList<AcademicYear> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }

    public final AcademicYear getType(int position) {
        if (position > 0) {
            AcademicYear academicYear = this.items.get(position - 1);
            Intrinsics.checkNotNullExpressionValue(academicYear, "items[position-1]");
            return academicYear;
        }
        return new AcademicYear(0, "");
    }
}