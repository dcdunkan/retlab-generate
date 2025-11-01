package in.etuwa.app.ui.exam;

import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.data.model.exam.ExamFiles;
import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: ExamListener.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0007H&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J \u0010\u000f\u001a\u00020\u00072\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013H&¨\u0006\u0014"}, d2 = {"Lin/etuwa/app/ui/exam/ExamListener;", "", "checkFileExistence", "", "fileName", "", "deleteExam", "", "id", "downloadFile", "url", CommonCssConstants.POSITION, "", "onDismiss", "onPickDoc", "openDownloadDialog", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/exam/ExamFiles;", "Lkotlin/collections/ArrayList;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ExamListener {
    boolean checkFileExistence(String fileName);

    void deleteExam(String id);

    void downloadFile(String url, int position);

    void onDismiss();

    void onPickDoc(String id);

    void openDownloadDialog(ArrayList<ExamFiles> list);
}