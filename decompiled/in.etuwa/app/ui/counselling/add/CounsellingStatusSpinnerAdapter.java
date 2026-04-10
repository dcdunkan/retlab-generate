package in.etuwa.app.ui.counselling.add;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.counselling.status.CounsellingStatus;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CounsellingStatusSpinnerAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CounsellingStatusSpinnerAdapter extends BaseAdapter {
    private AppCompatActivity activity;
    private ArrayList<CounsellingStatus> items;

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    public CounsellingStatusSpinnerAdapter(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.items = new ArrayList<>();
    }

    public final ArrayList<CounsellingStatus> getItems() {
        return this.items;
    }

    public final void setItems(ArrayList<CounsellingStatus> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.items = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.items.size();
    }

    @Override // android.widget.Adapter
    public CounsellingStatus getItem(int position) {
        CounsellingStatus counsellingStatus = this.items.get(position);
        Intrinsics.checkNotNullExpressionValue(counsellingStatus, "items[position]");
        return counsellingStatus;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        return createView(position, convertView, parent);
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return createView(position, convertView, parent);
    }

    private final View createView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent != null ? parent.getContext() : null).inflate(R.layout.layout_fill_list, parent, false);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.fill_name);
        CounsellingStatus counsellingStatus = this.items.get(position);
        Intrinsics.checkNotNullExpressionValue(counsellingStatus, "items[position]");
        textView.setText(counsellingStatus.getName());
        Intrinsics.checkNotNullExpressionValue(convertView, "view");
        return convertView;
    }

    public final void addItems(ArrayList<CounsellingStatus> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }

    public final CounsellingStatus getType(int position) {
        CounsellingStatus counsellingStatus = this.items.get(position);
        Intrinsics.checkNotNullExpressionValue(counsellingStatus, "items[position]");
        return counsellingStatus;
    }
}