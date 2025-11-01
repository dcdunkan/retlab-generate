package in.etuwa.etlabstaff.ui.library.bookrecord;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.library.BookRecord;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BookRecordAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lin/etuwa/etlabstaff/ui/library/bookrecord/BookRecordAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "books", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/library/BookRecord;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/etlabstaff/ui/library/bookrecord/BookRecordAdapter$BooksCallBack;", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setBooksCallBack", "context", "Lin/etuwa/etlabstaff/ui/library/bookrecord/BookRecordFragment;", "BooksCallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BookRecordAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<BookRecord> books = new ArrayList<>();
    private BooksCallBack listener;

    /* compiled from: BookRecordAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lin/etuwa/etlabstaff/ui/library/bookrecord/BookRecordAdapter$BooksCallBack;", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface BooksCallBack {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(inflate);
        }
        if (viewType == 1) {
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_books_records, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …s_records, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.books.size() > 0) {
            return this.books.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.books.isEmpty() ? 1 : 0;
    }

    /* compiled from: BookRecordAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0017R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lin/etuwa/etlabstaff/ui/library/bookrecord/BookRecordAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/etlabstaff/ui/library/bookrecord/BookRecordAdapter;Landroid/view/View;)V", "bookNo", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "bookTitle", "dueDate", "fine", "fineStatus", "issueDate", "remarks", "renewDate", "returnDate", NotificationCompat.CATEGORY_STATUS, "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView bookNo;
        private final TextView bookTitle;
        private final TextView dueDate;
        private final TextView fine;
        private final TextView fineStatus;
        private final TextView issueDate;
        private final TextView remarks;
        private final TextView renewDate;
        private final TextView returnDate;
        private final TextView status;
        final /* synthetic */ BookRecordAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(BookRecordAdapter bookRecordAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = bookRecordAdapter;
            this.bookTitle = (TextView) itemView.findViewById(R.id.book_title);
            this.issueDate = (TextView) itemView.findViewById(R.id.book_issue_date);
            this.bookNo = (TextView) itemView.findViewById(R.id.book_no);
            this.dueDate = (TextView) itemView.findViewById(R.id.book_due_date);
            this.returnDate = (TextView) itemView.findViewById(R.id.books_returned_date);
            this.renewDate = (TextView) itemView.findViewById(R.id.books_renewal_date);
            this.fine = (TextView) itemView.findViewById(R.id.books_fine);
            this.remarks = (TextView) itemView.findViewById(R.id.books_remarks);
            this.fineStatus = (TextView) itemView.findViewById(R.id.books_fine_status);
            this.status = (TextView) itemView.findViewById(R.id.books_status);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.books.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "books[position]");
                BookRecord bookRecord = (BookRecord) obj;
                this.bookTitle.setText(bookRecord.getTitle());
                this.returnDate.setText(bookRecord.getReturned_date());
                this.issueDate.setText(bookRecord.getIssue_date());
                this.bookNo.setText(bookRecord.getSlno());
                this.dueDate.setText(bookRecord.getDue_date());
                this.renewDate.setText(bookRecord.getRenewal_date());
                this.fine.setText(bookRecord.getFine().toString());
                this.remarks.setText(bookRecord.getRemarks());
                this.status.setText(bookRecord.getStatus());
                if (Intrinsics.areEqual(bookRecord.is_paid(), "Paid")) {
                    this.fineStatus.setText("Paid");
                } else if (Intrinsics.areEqual(bookRecord.is_paid(), "false") && !Intrinsics.areEqual(this.fine.getText().toString(), "0")) {
                    this.fineStatus.setText("Not Paid");
                } else {
                    this.fineStatus.setText("");
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<BookRecord> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.books.clear();
        this.books.addAll(list);
        notifyDataSetChanged();
    }

    public final void setBooksCallBack(BookRecordFragment context) {
        this.listener = context;
    }
}