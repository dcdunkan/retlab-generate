package in.etuwa.app.ui.questionbank;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.materials.Materials;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QBFilterAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class QBFilterAdapter extends BaseAdapter {
    private AppCompatActivity activity;
    private ArrayList<Materials> items;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public QBFilterAdapter(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.items = new ArrayList<>();
    }

    /* JADX INFO: compiled from: QBFilterAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/ui/questionbank/QBFilterAdapter$ViewHolder;", "", CommonCssConstants.ROW, "Landroid/view/View;", "(Landroid/view/View;)V", "fillName", "Landroid/widget/TextView;", "getFillName", "()Landroid/widget/TextView;", "setFillName", "(Landroid/widget/TextView;)V", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class ViewHolder {
        private TextView fillName;

        public ViewHolder(View view) {
            this.fillName = view != null ? (TextView) view.findViewById(R.id.fill_name) : null;
        }

        public final TextView getFillName() {
            return this.fillName;
        }

        public final void setFillName(TextView textView) {
            this.fillName = textView;
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
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type in.etuwa.app.ui.questionbank.QBFilterAdapter.ViewHolder");
            viewHolder = (ViewHolder) tag;
        }
        Materials materials = this.items.get(position);
        Intrinsics.checkNotNullExpressionValue(materials, "items[position]");
        Materials materials2 = materials;
        TextView fillName = viewHolder.getFillName();
        if (fillName != null) {
            fillName.setText(materials2.getSubject());
        }
        return convertView;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        Materials materials = this.items.get(position);
        Intrinsics.checkNotNullExpressionValue(materials, "items[position]");
        return materials;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.items.size();
    }

    public final void addItems(ArrayList<Materials> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }

    public final void clearItems() {
        this.items.clear();
        notifyDataSetChanged();
    }

    public final Materials getData(int position) {
        Materials materials = this.items.get(position);
        Intrinsics.checkNotNullExpressionValue(materials, "items[position]");
        return materials;
    }
}