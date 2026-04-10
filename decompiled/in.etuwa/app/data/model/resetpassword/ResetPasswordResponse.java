package in.etuwa.app.data.model.resetpassword;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResetPasswordResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class ResetPasswordResponse {
    private final ArrayList<ResetPassword> resets;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResetPasswordResponse copy$default(ResetPasswordResponse resetPasswordResponse, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = resetPasswordResponse.resets;
        }
        return resetPasswordResponse.copy(arrayList);
    }

    public final ArrayList<ResetPassword> component1() {
        return this.resets;
    }

    public final ResetPasswordResponse copy(ArrayList<ResetPassword> resets) {
        Intrinsics.checkNotNullParameter(resets, "resets");
        return new ResetPasswordResponse(resets);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ResetPasswordResponse) && Intrinsics.areEqual(this.resets, ((ResetPasswordResponse) other).resets);
    }

    public int hashCode() {
        return this.resets.hashCode();
    }

    public String toString() {
        return "ResetPasswordResponse(resets=" + this.resets + ")";
    }

    public ResetPasswordResponse(ArrayList<ResetPassword> resets) {
        Intrinsics.checkNotNullParameter(resets, "resets");
        this.resets = resets;
    }

    public final ArrayList<ResetPassword> getResets() {
        return this.resets;
    }
}