import Box, {BoxProps, BoxTypeMap} from '@mui/material/Box'

function CrossBox() {
    return (
        <Box
            sx={{
                position:"relative",
                overflow: "hidden",
                width: "inherit",
                height: "inherit",
                display: "flex",
                border: "3px solid black",
                backgroundColor: 'white',
                justifyContent: "center",
                alignItems: "center"
            }}>
                <div style={{
                    backgroundColor: "black",
                    width: 3,
                    height: "inherit",
                    transform: "rotate(47deg)",
                }}/>

                <div style={{
                    backgroundColor: "black",
                    width: 3,
                    height: "inherit",
                    transform: "rotate(-47deg)"
                }}/>
        </Box>
    )
}

export default CrossBox
