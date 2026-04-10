package in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOfYearSpinnerAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class NoOfYearSpinnerAdapter extends BaseAdapter {
    private AppCompatActivity activity;
    private ArrayList<String> items;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public NoOfYearSpinnerAdapter(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.items = new ArrayList<>();
    }

    /* JADX INFO: compiled from: NoOfYearSpinnerAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/ui/hostel/gcekhostel/registration/reregistration/NoOfYearSpinnerAdapter$ViewHolder;", "", CommonCssConstants.ROW, "Landroid/view/View;", "(Landroid/view/View;)V", "semName", "Landroid/widget/TextView;", "getSemName", "()Landroid/widget/TextView;", "setSemName", "(Landroid/widget/TextView;)V", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.NoOfYearSpinnerAdapter.ViewHolder");
            viewHolder = (ViewHolder) tag;
        }
        String str = this.items.get(position);
        Intrinsics.checkNotNullExpressionValue(str, "items[position]");
        String str2 = str;
        TextView semName = viewHolder.getSemName();
        if (semName != null) {
            semName.setText(str2);
        }
        return convertView;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        String str = this.items.get(position);
        Intrinsics.checkNotNullExpressionValue(str, "items[position]");
        return str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.items.size();
    }

    public final void addItems(String[] list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.items.clear();
        CollectionsKt.addAll(this.items, list);
        notifyDataSetChanged();
    }

    public final String getSemester(int position) {
        String str = this.items.get(position);
        Intrinsics.checkNotNullExpressionValue(str, "items[position]");
        return str;
    }
}