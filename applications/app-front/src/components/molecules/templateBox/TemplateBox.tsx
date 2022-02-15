import React, {CSSProperties} from 'react'

function TemplateBox(props:React.DetailedHTMLProps<React.HTMLAttributes<HTMLDivElement>, HTMLDivElement>) {
    const templateStyle:CSSProperties | undefined = {
        margin: 0,
        alignItems: "center",
        justifyContent: "center",
        fontSize: "1.5em",
        border: "3px solid black",
        backgroundColor: "white",
        display: "flex"
    }

    return (
        <div style={ props.children != undefined ? props.style : { ...templateStyle, ...props.style}}>
        {
            props.children ? props.children : <p>{props.style?.width} x {props.style?.height}</p>
        }
    </div>
    )
}

export default TemplateBox;