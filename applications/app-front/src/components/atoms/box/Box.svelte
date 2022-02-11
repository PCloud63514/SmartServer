<script lang="ts">
    export let style: any
    console.log(style)
</script>

<div class="box" style="{style}">
    <slot></slot>
</div>

<style>
    .box {
        border: 1px solid #aaa;
        box-shadow: 2px 2px 8px rgba(0,0,0,0.1);
    }
</style>
