package in.etuwa.app.ui.teacher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import com.squareup.picasso.Picasso;
import in.etuwa.app.R;
import in.etuwa.app.data.model.common.Teacher;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TeacherAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class TeacherAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<Teacher> teachers = new ArrayList<>();
    private final List<String> strokeColors = CollectionsKt.listOf((Object[]) new String[]{"#FFCDD2", "#F8BBD0", "#E1BEE7", "#D1C4E9", "#C5CAE9", "#BBDEFB", "#B2EBF2", "#C8E6C9", "#FFF9C4", "#FFE0B2"});

    public final List<String> getStrokeColors() {
        return this.strokeColors;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(viewInflate);
        }
        if (viewType == 1) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_teacher, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …w_teacher, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.teachers.size() > 0) {
            return this.teachers.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.teachers.isEmpty() ? 1 : 0;
    }

    /* JADX INFO: compiled from: TeacherAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/ui/teacher/TeacherAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/teacher/TeacherAdapter;Landroid/view/View;)V", "email", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", SvgConstants.Tags.IMAGE, "Landroid/widget/ImageView;", "phone", "subject", "teacherName", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView email;
        private final ImageView image;
        private final TextView phone;
        private final TextView subject;
        private final TextView teacherName;
        final /* synthetic */ TeacherAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(TeacherAdapter teacherAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = teacherAdapter;
            this.teacherName = (TextView) itemView.findViewById(R.id.teacher_name);
            this.subject = (TextView) itemView.findViewById(R.id.teacher_subject);
            this.email = (TextView) itemView.findViewById(R.id.teacher_email);
            this.phone = (TextView) itemView.findViewById(R.id.teacher_phone);
            this.image = (ImageView) itemView.findViewById(R.id.image);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.teachers.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "teachers[position]");
                Teacher teacher = (Teacher) obj;
                this.teacherName.setText(teacher.getTeacher());
                this.subject.setText(teacher.getSubject());
                this.email.setText(teacher.getMail());
                String phone = teacher.getPhone();
                if (phone == null || phone.length() == 0) {
                    this.phone.setVisibility(8);
                } else {
                    this.phone.setVisibility(0);
                    this.phone.setText(teacher.getPhone());
                }
                Picasso.get().load(teacher.getImage()).placeholder(R.drawable.user_new).error(R.drawable.user_new).transform(new CircleTransform()).into(this.image);
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<Teacher> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.teachers.clear();
        this.teachers.addAll(list);
        notifyDataSetChanged();
    }
}