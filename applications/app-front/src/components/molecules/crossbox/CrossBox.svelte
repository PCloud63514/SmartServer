<script lang="ts">
    import { Box } from '../../atoms'
</script>

<Box style="width: -moz-max-content; background-color: yellow">
    <svg>
        <line x1="250" x2="bind" y1="0" y2="250"></line>
        <line x1="250" x2="0" y1="250" y2="0"></line>
    </svg>
</Box>

<style>
    svg {
        overflow: visible;
    }

    line {
        border:  3px;
        fill: none;
        stroke: black;
    }
</style>

