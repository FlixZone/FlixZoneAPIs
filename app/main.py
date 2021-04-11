from fastapi import FastAPI

app = FastAPI()


@app.get("/", tags=["Root"])
async def read_root():
    return {
        "message" : "The FlixZoneWebAPI is up and running !",
        "docs":"/docs",
    }
