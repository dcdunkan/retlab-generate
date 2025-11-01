package in.etuwa.app.ui.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.institutions.Colleges;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CollegeSpinnerAdapter.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lin/etuwa/app/ui/login/CollegeSpinnerAdapter;", "Landroid/widget/BaseAdapter;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", FirebaseAnalytics.Param.ITEMS, "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/institutions/Colleges;", "Lkotlin/collections/ArrayList;", "addItems", "", "list", "getCollege", CommonCssConstants.POSITION, "", "getCount", "getItem", "", "getItemId", "", "i", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CollegeSpinnerAdapter extends BaseAdapter {
    private AppCompatActivity activity;
    private ArrayList<Colleges> items;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public CollegeSpinnerAdapter(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.items = new ArrayList<>();
    }

    /* compiled from: CollegeSpinnerAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/ui/login/CollegeSpinnerAdapter$ViewHolder;", "", CommonCssConstants.ROW, "Landroid/view/View;", "(Landroid/view/View;)V", "teachName", "Landroid/widget/TextView;", "getTeachName", "()Landroid/widget/TextView;", "setTeachName", "(Landroid/widget/TextView;)V", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class ViewHolder {
        private TextView teachName;

        public ViewHolder(View view) {
            this.teachName = view != null ? (TextView) view.findViewById(R.id.clg_name) : null;
        }

        public final TextView getTeachName() {
            return this.teachName;
        }

        public final void setTeachName(TextView textView) {
            this.teachName = textView;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            Object systemService = this.activity.getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            convertView = ((LayoutInflater) systemService).inflate(R.layout.layout_college_list, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(convertView, "inflater.inflate(R.layou…ayout_college_list, null)");
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            Object tag = convertView.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type in.etuwa.app.ui.login.CollegeSpinnerAdapter.ViewHolder");
            viewHolder = (ViewHolder) tag;
        }
        Colleges colleges = this.items.get(position);
        Intrinsics.checkNotNullExpressionValue(colleges, "items[position]");
        Colleges colleges2 = colleges;
        TextView teachName = viewHolder.getTeachName();
        if (teachName != null) {
            teachName.setText(colleges2.getClgName());
        }
        return convertView;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        Colleges colleges = this.items.get(position);
        Intrinsics.checkNotNullExpressionValue(colleges, "items[position]");
        return colleges;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.items.size();
    }

    public final void addItems(ArrayList<Colleges> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }

    public final Colleges getCollege(int position) {
        Colleges colleges = this.items.get(position);
        Intrinsics.checkNotNullExpressionValue(colleges, "items[position]");
        return colleges;
    }
}