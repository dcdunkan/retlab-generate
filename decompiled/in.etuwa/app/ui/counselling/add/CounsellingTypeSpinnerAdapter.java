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
import in.etuwa.app.data.model.counselling.type.CounsellingTypes;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CounsellingTypeSpinnerAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CounsellingTypeSpinnerAdapter extends BaseAdapter {
    private AppCompatActivity activity;
    private ArrayList<CounsellingTypes> items;

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    public CounsellingTypeSpinnerAdapter(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.items = new ArrayList<>();
    }

    public final ArrayList<CounsellingTypes> getItems() {
        return this.items;
    }

    public final void setItems(ArrayList<CounsellingTypes> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.items = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.items.size();
    }

    @Override // android.widget.Adapter
    public CounsellingTypes getItem(int position) {
        CounsellingTypes counsellingTypes = this.items.get(position);
        Intrinsics.checkNotNullExpressionValue(counsellingTypes, "items[position]");
        return counsellingTypes;
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
        CounsellingTypes counsellingTypes = this.items.get(position);
        Intrinsics.checkNotNullExpressionValue(counsellingTypes, "items[position]");
        textView.setText(counsellingTypes.getName());
        Intrinsics.checkNotNullExpressionValue(convertView, "view");
        return convertView;
    }

    public final void addItems(ArrayList<CounsellingTypes> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }

    public final CounsellingTypes getType(int position) {
        CounsellingTypes counsellingTypes = this.items.get(position);
        Intrinsics.checkNotNullExpressionValue(counsellingTypes, "items[position]");
        return counsellingTypes;
    }
}