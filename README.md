Check out https://github.com/dcdunkan/retlab.

#### Steps

1. Extract Etlab APK
2. Decompile it using JADX
3. Export as Java output
4. Paste into decompiled/
5. Generate the following by running `pnpm run build`:
   - Types
   - API Endpoints
   - Hoppscotch compatible API collection (for all routes)
6. Import the generated collection JSON to Hoppscotch or Postman to view it.

#### TODO

Currently only `application/json` requests are documented. Need to document
`application/x-www-form-urlencoded` and `multipart/form-data`.
